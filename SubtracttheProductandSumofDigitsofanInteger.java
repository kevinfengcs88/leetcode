class Solution {
    public int subtractProductAndSum(int n) {
        String s1 = String.valueOf(n);
        int[] digits = new int[s1.length()];
        int product = 1;
        int sum = 0;
        for (int i = 0; i < digits.length; i++){
            digits[i] = Integer.parseInt(String.valueOf(s1.charAt(i)));
            product *= digits[i];
            sum += digits[i];
        }
        return product - sum;
    }
}
