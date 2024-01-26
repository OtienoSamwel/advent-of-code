package twenty_twenty_two

import java.io.File

fun main() {
    partOne()
    partTwo()
}

private fun getData(): List<String> = File("./src/main/kotlin/twenty_twenty_two/data/daySeven.txt").readLines()


private fun partOne() {
    val fileTree = getFileTree()

    println(fileTree.getAllFolders().sumOf {
        val memory = it.calculateNodeMemory()
        if (memory <= 100_000) memory else 0
    })
}

private fun getFileTree(): Node {
    val fileTree = Node(name = "/", mutableListOf(), 0, parent = null)
    var currentDir = fileTree
    val commands = getData()

    commands.forEach { command ->

        if (command.contains("$")) {
            if (command.contains("cd")) {
                when (val cdArg = command.split(" ").last().trim()) {
                    ".." -> currentDir = currentDir.parent!!
                    "/" -> {}
                    else -> {
                        currentDir = currentDir.children.first { it.name == cdArg }
                    }
                }
            }

        } else if (command.contains("dir")) {
            //create a new node a child of the current node
            val name = command.split(" ").last().trim()
            currentDir.children.add(
                Node(
                    name = name,
                    children = mutableListOf(),
                    totalNodeFileMemoryValue = 0,
                    parent = currentDir
                )
            )
        } else {
            //it is a list of files starting with the size
            val fileSize = command.split(" ").first().trim().toInt()
            currentDir.totalNodeFileMemoryValue += fileSize
        }
    }
    return fileTree
}

private fun partTwo() {
    val fileTree = getFileTree()
    println(fileTree.getAllFolders().size)

    val totalSpace = 70_000_000
    val usedSpace = fileTree.calculateNodeMemory()
    val unusedSpace = totalSpace - usedSpace

    val requiredSpace = 30_000_000 - unusedSpace

    println("used $usedSpace")
    println(
        "part two : ${
            fileTree.getAllFolders().filter { folder ->
                folder.calculateNodeMemory() >= requiredSpace
            }.minOf { it.calculateNodeMemory() }
        }"
    )
}

data class Node(
    val name: String,
    val children: MutableList<Node>,
    var totalNodeFileMemoryValue: Int,
    val parent: Node?
) {

    fun calculateNodeMemory(): Int {
        if (children.isEmpty()) {
            return this.totalNodeFileMemoryValue
        }
        return children.sumOf { it.calculateNodeMemory() } + this.totalNodeFileMemoryValue
    }

    fun getAllFolders(): List<Node> {
        if (children.isEmpty()) {
            return listOf(this)
        }

        return children.flatMap { it.getAllFolders() } + this
    }

}


fun List<Int>.hello() {
    this.forEach {
        print("hello $it")
    }
}

