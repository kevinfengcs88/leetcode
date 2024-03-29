class Solution {
    public int[] smallerNumbersThanCurrentNaive(int[] nums) {    // naive solution
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if (nums[i] > nums[j]) result[i]++;
            }
        }
        return result;
    }
    public int[] smallerNumbersThanCurrent(int[] nums){ // O(nlogn) solution using HashMap
        int[] result = nums.clone();
        Arrays.sort(result);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++){
            map.putIfAbsent(result[i], i);
        }
        for (int i = 0; i < result.length; i++){
            result[i] = map.get(nums[i]);
        }
        return result;
    }
}
