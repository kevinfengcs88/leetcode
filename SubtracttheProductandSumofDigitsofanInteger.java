class Solution {
    public int subtractProductAndSum(int n) {   // solution using string conversion
        String s1 = String.valueOf(n);
        int product = 1;
        int sum = 0;
        for (int i = 0; i < s1.length(); i++){
            int temp = Integer.parseInt(String.valueOf(s1.charAt(i)));
            product *= temp;
            sum += temp;
        }
        return product - sum;
    }
    public int sub(int n){  // solution without string conversion
        if (n == 0) return 0;
        int length = (int)(Math.log10(n) + 1);
        int[] digits = new int[length];
        int product = 1;
        int sum = 0;
        int i = 0;
        while (n != 0){
            digits[i] = n % 10;
            n /= 10;
            i++;
        }
        for (int j = 0; j < digits.length; j++){
            product *= digits[j];
            sum += digits[j];
        }
        return product - sum;
    }
}
