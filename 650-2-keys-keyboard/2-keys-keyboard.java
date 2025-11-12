class Solution {
    public int minSteps(int n) {
        int[][] dp= new int[n+1][n+1];
        for(int[] A:dp){
            Arrays.fill(A,-1);
        }
     
        return Solve(n,1,0,0,dp);
    }
    public static int Solve(int n, int curr, int clipboard, int steps, int[][] dp){

        if(curr>n || clipboard>n){
            return Integer.MAX_VALUE;
        }
        if(curr==n){
            return steps;
        }
        if(dp[curr][clipboard]!=-1) return dp[curr][clipboard];

        int copy=Integer.MAX_VALUE;
        int paste=Integer.MAX_VALUE;
        if(clipboard!=curr){
            copy= Solve(n,curr,curr,steps+1,dp);
        }
        if(clipboard>0){
            paste= Solve(n,curr+clipboard,clipboard,steps+1,dp);
        }
        return dp[curr][clipboard]=Math.min(copy,paste);

    }
}