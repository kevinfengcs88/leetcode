class Solution {
    public int subtractProductAndSum(int n) {
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
