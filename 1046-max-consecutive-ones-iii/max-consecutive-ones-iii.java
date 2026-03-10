class Solution {
    public int longestOnes(int[] nums, int k) {
        int used=0;
        int si=0;
        int ei=0;
        int ans=0;
        int curr=0;
        while(ei<nums.length){
            if(nums[ei]==1){
                curr++;
                ans=Math.max(ans,curr);
            }
            else{
                if(used<k){
                    curr++;
                    used++;
                    
                }
                else{
                    ans=Math.max(ans,curr);
                    while(used>=k){
                        if(nums[si]==0){
                            used--;
                            
                        }
                        curr--; // Decrement even if it is 1 or 0
                        si++;
                    }
                    // include current element in window
                    used++;
                    curr++;
                }
            }
            ans=Math.max(ans,curr);
            ei++;


        }
        return ans;
        
    }
}