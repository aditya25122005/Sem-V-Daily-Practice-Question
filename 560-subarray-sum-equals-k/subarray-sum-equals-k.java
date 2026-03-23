class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        //curr prefix sum kitni baar mila hai wo store karenge

        map.put(0,1); // 0 mila hai 1 baar
        int curr=0;
        int ans=0;
        for(int num: nums){
            curr+=num;
            if(map.containsKey(curr-k)){
                ans+= map.get(curr-k);
            }   
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return ans;
    }
}