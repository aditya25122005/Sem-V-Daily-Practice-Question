class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int[][] dp= new int[arr.length][arr[0].length];
        for(int []a:dp){
            Arrays.fill(a,-1);
        }
        return solve(arr,0,0,dp);
    }
    public static int solve(int[][] arr, int cr, int cc,int[][]dp){
        if(cr>=arr.length || cc>=arr[0].length || arr[cr][cc]==1){
            return 0;
        }
        if(cr==arr.length-1 && cc==arr[0].length-1){
            return 1;
        }
        
        int path=0;
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        int f= solve(arr,cr+1,cc,dp);
        int s= solve(arr,cr,cc+1,dp);
        path=f+s;
        return dp[cr][cc]=path;   
    }
}