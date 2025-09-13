class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int [][] dp= new int[matrix.length][matrix[0].length];
        for(int []a:dp){
            Arrays.fill(a,9999999);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            ans=Math.min(ans,Solve(matrix,0,i,dp));
        }
        return ans;
    }
    public static int Solve(int[][]arr, int r, int c, int[][] dp){

        if(r>=arr.length){
            return Integer.MAX_VALUE;
        }
        if(c>=arr[0].length || c<0){
            return Integer.MAX_VALUE;
        }
        if(r==arr.length-1){
            return arr[r][c];
        }
        if(dp[r][c]!=9999999){
            return dp[r][c];
        }
        int ans=0;
        int f = Solve(arr,r+1,c-1,dp);
        int s = Solve(arr,r+1,c,dp);
        int t = Solve(arr,r+1,c+1,dp);
        ans=Math.min(f,Math.min(s,t));

        return dp[r][c]=ans+arr[r][c];


    }
}