class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n<=1) return true;
        boolean [] dp= new boolean[nums.length];
        dp[n-1]=true;
        for(int i=n-2;i>=0;i--){
            int maxJump= Math.min(n-1,i+nums[i]);
            for(int j=i+1;j<=maxJump;j++){
                if(dp[j]){
                    dp[i]=true;
                    break;
                } 
            }
        }
        return dp[0];

    }
}