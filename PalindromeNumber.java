class Solution {
    public static boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        char c;
        String reverseInput = "";
        for (int i = 0; i < input.length(); i++){
            c = input.charAt(i);
            reverseInput = c + reverseInput;
        }
        return (input.equals(reverseInput));
    }
}