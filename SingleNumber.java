class Solution{
    public <K,V> K getKey(Map<K,V> map, V value){   // helper function
        for (Map.Entry<K,V> entry: map.entrySet()){
            if (value.equals(entry.getValue())) return entry.getKey();
        }
        return null;
    }
    public int singleNumber(int[] nums){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], 2);
        }
        return getKey(map, 1);
    }
}
