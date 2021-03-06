class Solution{
    public <K,V> K getKey(Map<K,V> map, V value){   // helper function
        for (Map.Entry<K,V> entry: map.entrySet()){
            if (value.equals(entry.getValue())) return entry.getKey();
        }
        return null;
    }
    public int naiveSingleNumber(int[] nums){    // runs in O(n) time, but also uses O(n) extra space
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], 2);
        }
        return getKey(map, 1);
    }
    public int singleNumber(int[] nums){    // runs in O(n) time, takes O(1) extra space
        int result = 0;
        for (int i = 0; i < nums.length; i++) result ^= nums[i];
        return result;
    }
}
