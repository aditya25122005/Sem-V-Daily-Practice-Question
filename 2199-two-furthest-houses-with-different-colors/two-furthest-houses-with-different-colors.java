class Solution {
    public int maxDistance(int[] colors) {
        int [][] dp = new int[colors.length][colors.length];
        for(int [] A: dp)Arrays.fill(A,-1);
        return Solve(colors,0,colors.length-1,dp);
    }
    public static int Solve(int [] colors, int i, int j,int [][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int A=0;
        int B=0;
        int C=0;
        if(colors[i]!= colors[j]){
            return Math.abs(i-j);
        }
        else{
            A = Solve(colors,i+1,j,dp);
            B = Solve(colors, i,j-1,dp);
            C = Solve(colors,i+1,j-1,dp);
        }
        return dp[i][j] = Math.max(A,Math.max(B,C));
    }
}