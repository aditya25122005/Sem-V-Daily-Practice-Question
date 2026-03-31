class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] dp= new Integer[cost.length];
        return Math.min(Solve(cost,0,dp), Solve(cost,1,dp));
    }
    public static int Solve(int[] cost, int idx,Integer[] dp){
        if(idx>cost.length){
            return Integer.MAX_VALUE;
        }
        if(idx==cost.length){
            return 0;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        int A=Integer.MAX_VALUE;
        int B=Integer.MAX_VALUE;

        int next1= Solve(cost,idx+1,dp);
        if(next1 != Integer.MAX_VALUE){
            A=cost[idx]+ next1;
        }
        int next2=Solve(cost,idx+2,dp);
        if(next2!= Integer.MAX_VALUE){
            B= cost[idx]+ next2;
        }

        

        return dp[idx] = Math.min(A,B);

    }
}