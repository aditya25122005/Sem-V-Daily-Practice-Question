class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        int min=0;
        
        for(int num:nums){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        int [] dp= new int[max+1];
        Arrays.fill(dp,-1);
        int [] points= new int[max+1];
        for(int num:nums){
            points[num]+= num;
        }
        return Solve(points,min,dp);

    }
    public static int Solve(int[] points, int idx, int[] dp){
        if(idx>=points.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int a= points[idx]+Solve(points,idx+2,dp);
        int b=Solve(points,idx+1,dp);
         return dp[idx]=Math.max(a,b);
    }
}