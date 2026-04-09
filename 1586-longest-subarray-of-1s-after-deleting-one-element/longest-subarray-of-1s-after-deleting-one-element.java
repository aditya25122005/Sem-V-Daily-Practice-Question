class Solution {
    public int longestSubarray(int[] nums) {
        int si=0;
        int ei=0;
        int curr=0;
        int ans=0;
        boolean used=false;
        while(ei<nums.length){
            if(nums[ei]==1){
                curr++;
                ans=Math.max(ans,curr);
            }
            else{
                if(!used){
                    used=true;
                }
                else{
                    while(used){
                        if(nums[si]==0){
                            used=false;
                            si++;
                        }
                        else{
                            curr--;
                            si++;
                        }
                    }
                    used=true;
                }
                ans=Math.max(ans,curr);
            }
            ei++;
        }
        return used? ans: ans-1;
    }
}