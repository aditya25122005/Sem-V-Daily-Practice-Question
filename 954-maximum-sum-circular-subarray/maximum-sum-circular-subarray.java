class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        for(int num: nums){
            total+=num;
        }
        int minS = minSum(nums);
        int maxS= maxSum(nums);
        
        if(minS==total){
            return maxS;
        }

        return Math.max(maxS,total-minS);
        
    }
    public static int minSum(int [] nums){
        int ans=Integer.MAX_VALUE;
        int curr = 0;
        for(int num: nums){
            curr+=num;
            ans=Math.min(ans,curr);
            if(curr>0){
                curr=0;
            }
        }
        //ans=Math.min(ans,curr);
        return ans;
    }
    public static int maxSum(int [] nums){
        int ans = Integer.MIN_VALUE;
        int curr=0;
        for(int num: nums){
            curr+=num;
            ans=Math.max(ans,curr);
            if(curr<0){
                curr=0;
            }
        }
        //ans=Math.max(ans,curr);
        return ans;
    }
}