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
        if(cc<0 || cc>=matrix[0].length){
            return Integer.MAX_VALUE;
        }
        if(cr==matrix.length-1){
            return matrix[cr][cc];
        }
        if(dp[cr][cc]!=-66666){
            return dp[cr][cc];
        }
        int ld= Path(matrix, cr+1, cc-1, dp);
        int rd= Path(matrix, cr+1, cc+1, dp);
        int d=Path(matrix, cr+1, cc, dp);
        return dp[cr][cc]=Math.min(rd,Math.min(ld,d))+matrix[cr][cc];
    }
}