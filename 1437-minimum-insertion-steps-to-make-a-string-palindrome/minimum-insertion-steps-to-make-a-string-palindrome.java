class Solution {
    public int minInsertions(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return Solve(s,0,s.length()-1,dp);
    }
    public static int Solve(String s, int i , int j,Integer[][] dp ){
        if(i>=j){
            return 0;
        }
        if(s.charAt(i)==s.charAt(j)){
            return Solve(s,i+1,j-1,dp);
        }
        if(dp[i][j] != null) return dp[i][j];
        else{
            int A = Integer.MAX_VALUE;
            int B = Integer.MAX_VALUE;
            A = 1+Solve(s,i+1,j,dp);
            B = 1+Solve(s,i,j-1,dp);
            return dp[i][j] = Math.min(A,B);
        }
    }
}