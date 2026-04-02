class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        Integer [][] dp= new Integer[matrix.length][matrix.length];

        for(int j=0;j<matrix[0].length;j++){
            ans = Math.min(ans, Solve(matrix, 0, j,dp));
        }
        return ans;
    }
    public static int Solve(int [][] matrix , int i, int j,Integer[][] dp){
        if(i>= matrix.length || j>= matrix[0].length || j<0 ){
            return Integer.MAX_VALUE;
        }
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        if(dp[i][j] != null) return dp[i][j];
        int A= Integer.MAX_VALUE;
        int B= Integer.MAX_VALUE;
        int C= Integer.MAX_VALUE;

        int next1=Solve(matrix, i+1,j,dp);
        if(next1!= Integer.MAX_VALUE){
            A= matrix[i][j]+ next1;
        }
        int next2= Solve(matrix, i+1,j-1,dp);
        if(next2!= Integer.MAX_VALUE){
            B= matrix[i][j]+ next2;
        }
        int next3= Solve(matrix, i+1,j+1,dp);
        if(next3!= Integer.MAX_VALUE){
            C= matrix[i][j]+ next3;
        }
        return dp[i][j] = Math.min(A,Math.min(B,C));
    }
}