class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        // -1, 0, -1
        // -1 0 1 2 3 4 3 2 1 ->(2,8)->  8-2=6
        // -1 0 

        // -1 0, -1 ,0
        map.put(0,-1);
        int ans=0;
        int curr=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                curr++;
            }
            else{
                curr--;
            }
            
            if(map.containsKey(curr)){
                ans=Math.max(ans,i-map.get(curr));
            }
            else{
                map.put(curr,i);
            }
            
        }
        return ans;
    }
}