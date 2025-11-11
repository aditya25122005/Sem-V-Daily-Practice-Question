class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][][] dp= new int[m+1][n+1][strs.length+1];
        for(int[][] A:dp){
            for(int []a:A){
                Arrays.fill(a,-1);
            }
        }
        return Solve(strs,0,0,0,m,n,dp);
    }
    public static int Solve(String[] strs, int idx,int zero, int one, int m, int n, int[][][] dp){
        if(idx==strs.length){
            return 0;
        }
        if(one>n || zero>m){
            return 0;
        }
        if(dp[zero][one][idx]!=-1) return dp[zero][one][idx];
        int c0= cnt0(strs[idx]);
        int c1= cnt1(strs[idx]);
        int pick=0;
        int nopick=0;
        
        if(c0+zero<=m && c1+one<=n){
            pick= 1+Solve(strs,idx+1,zero+c0, one+c1,m,n,dp);
         
        }
        nopick= Solve(strs,idx+1,zero,one,m,n,dp);
        
        return dp[zero][one][idx]  = Math.max(pick,nopick);

    }
    public static int cnt0(String s){
        int zero=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') zero++;
        }
        return zero;
    }
    public static int cnt1(String s){
        int one=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') one++;
        }
        return one;
    }
}