class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int si=0;
        int ei=0;
        int ans=Integer.MAX_VALUE;
        int n= nums.length;
        int sum=0;

        while(ei<n){
            sum+= nums[ei];
            if(sum>=target){
                ans=Math.min(ans,ei-si+1);
            }

            while(sum>target && si<ei){
                sum-=nums[si];
                si++;
                    if(sum>=target){
                    ans=Math.min(ans,ei-si+1);
                    }
            }
            
            if(sum>=target){
                ans=Math.min(ans,ei-si+1);
            }
            ei++;
        }
        return ans==Integer.MAX_VALUE? 0:ans ;

    }
}