class Solution {
    public int longestOnes(int[] nums, int k) {
        int si=0;
        int ei=0;
        int ans=0;
        int curr=0;
        while(ei<nums.length){

            if(nums[ei]==1){
                curr++;
                ans=Math.max(ans,ei-si+1);
            }
            else{
                if(k>0){
                    curr++;
                    k--;
                    ans=Math.max(ans,ei-si+1);
                }
                else{
                    while(si<=ei && k<=0){
                        if(nums[si]==0){
                            curr--;
                            k++;
                        }
                        si++;
                    }
                    k--;
                    curr++;
                    ans=Math.max(ans,ei-si+1);
                }
            }
            ei++;
        }
        return ans;
    }
}