class Solution {
    public long mostPoints(int[][] questions) {
        long [] dp= new long[questions.length];
        Arrays.fill(dp,-1);
        return Solve(questions,0,dp);
    }
    public static long Solve(int[][] questions, int idx, long [] dp){
        if(idx>= questions.length){
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];
        long A = questions[idx][0]+ Solve(questions, idx+ questions[idx][1]+1,dp);
        long B = Solve(questions,idx+1,dp);
        return dp[idx] = Math.max(A,B);
    }
}