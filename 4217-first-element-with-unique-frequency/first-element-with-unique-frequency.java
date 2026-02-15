class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        HashMap<Integer,Integer> valMap= new HashMap<>();
        for(int key: map.keySet()){
            int val= map.get(key);
            valMap.put(val, valMap.getOrDefault(val,0)+1);
        }
        for(int num:nums){
            int freq= map.get(num);
            if(valMap.get(freq)==1){
                return num;
            }
        }
        return -1;
    }
}