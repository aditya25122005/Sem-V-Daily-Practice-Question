class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans=Integer.MAX_VALUE;
        int [][] dp= new int[matrix.length][matrix[0].length];
        for(int []a:dp){
            Arrays.fill(a, -66666);
        }
        for(int i=0;i<matrix[0].length;i++){ // i -->col
            ans=Math.min(ans, Path(matrix, 0, i, dp));
        }
        return ans;
    }
    public static int Path(int [][] matrix, int cr,int cc, int[][] dp){
        if(cr==matrix.length-1){
            return matrix[cr][cc];
        }
        if(dp[cr][cc]!=-66666){
            return dp[cr][cc];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            if(i==cc){
                continue;
            }
            ans=Math.min(ans,Path(matrix,cr+1,i,dp));
        }
        return dp[cr][cc]=ans+matrix[cr][cc];
    }
}