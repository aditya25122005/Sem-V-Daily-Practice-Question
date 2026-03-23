class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int curr=0;
        int ans=0;
        for(int num: nums){
            curr+= num;
            if(map.containsKey(curr-goal)){
                ans+= map.get(curr-goal);
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return ans;
    }
}