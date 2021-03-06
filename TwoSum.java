class Solution {
    public int[] twoSumNaive(int[] nums, int target) {   // naive solution
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] + nums[i] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    public int[] twoSum(int[] nums, int target) {   // proper O(n) solution
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
