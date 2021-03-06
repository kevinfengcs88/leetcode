class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int idx = 0;    // traverses ans, not nums
        while(idx < ans.length){
            for (int i = 0; i < nums.length; i++){
                ans[idx] = nums[i];
                idx++;
            }
        }
        return ans;
    }
}
