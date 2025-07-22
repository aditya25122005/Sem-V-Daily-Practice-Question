class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ei=0;
        int si=0;
        int curr=0;
        int ans=0;
        HashSet<Integer> h1=new HashSet<>();
        while(ei<nums.length){
            if(h1.add(nums[ei])){
                curr+=nums[ei];
                ans=Math.max(ans,curr);
                ei++;
            }
            else{
                curr-=nums[si];
                h1.remove(nums[si]);
                si++;
                
            }
        }
        return ans;
    }
}