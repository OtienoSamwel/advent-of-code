
public static class QuestionOne {
    public static String reverseWords(String s) {
        //remove whitespace and split the list  int an array of words
        String[] wordList = s.trim().split("\\s+");

        int leftIndex = 0, rightIndex = wordList.length - 1;

        while (leftIndex < rightIndex) {
            String temp = wordList[leftIndex];
            wordList[leftIndex] = wordList[rightIndex];
            wordList[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }

        // join to single string
        return String.join(" ", wordList);
    }
}


public static void main() {
    System.out.println("testing main");
}