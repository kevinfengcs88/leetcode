class Solution {
    public boolean isPalindrome(int x) {    // solution using string conversion
        String input = String.valueOf(x);
        char c;
        String reverseInput = "";
        for (int i = 0; i < input.length(); i++){
            c = input.charAt(i);
            reverseInput = c + reverseInput;
        }
        return (input.equals(reverseInput));
    }
    public boolean palin(int x){    // solution without string conversion
        int r = 0;
        int original = x;
        if (x < 0) return false;
        while (x != 0){
            r = (r * 10) + (x % 10);
            x /= 10;
        }
        return (r == original);
    }
}
