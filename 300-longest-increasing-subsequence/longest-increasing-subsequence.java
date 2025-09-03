class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp= new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    int x= dp[j];
                dp[i]=Math.max(dp[i],x+1);
                }
            }
        }
        // Arrays.sort(dp);
        // return dp[dp.length-1];

        return Arrays.stream(dp).max().getAsInt();
        
    }
}