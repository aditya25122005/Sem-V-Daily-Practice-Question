class Solution {
    public int longestIdealString(String s, int k) {
        int [][] dp= new int[s.length()+1][26];
        for(int[] A:dp) Arrays.fill(A,-1);
        return Solve(s,0,-1,k,dp);
    }
    public static int Solve(String s, int idx ,int pre, int k, int[][]dp){
        if(idx==s.length()){
            return 0;
        }
        if(pre!=-1){
            if(dp[idx][pre]!=-1){
                return dp[idx][pre];
            }
        }
        int a=0;
        int b=0;
     
        if(pre==-1 || Math.abs( (s.charAt(idx)-'a') - pre)<=k){
            a=1+Solve(s,idx+1,s.charAt(idx)-'a',k,dp);
           
        }
        b= Solve(s,idx+1,pre,k,dp);
        if(pre!=-1){
            dp[idx][pre]= Math.max(a,b);
        }
        return Math.max(a,b);
    }
}