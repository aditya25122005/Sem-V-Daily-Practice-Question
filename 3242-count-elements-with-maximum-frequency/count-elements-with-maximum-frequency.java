class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxFreq=Integer.MIN_VALUE;
        for(int key:map.keySet()){
            int val=map.get(key);
            maxFreq=Math.max(maxFreq,val);
        }
        int ans=0;
        for(int key:map.keySet()){
            if(map.get(key)==maxFreq){
                ans+=map.get(key);
            }
        }
        return ans;
    }
}