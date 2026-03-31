class Solution {
    public int numDecodings(String s) {
        Integer[] dp= new Integer[s.length()];
        return Solve(s,0,dp);
    }

    public static int Solve(String s, int idx,Integer[] dp){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx]!=null) return dp[idx];

        int A=0;
        int B=0;
        int C=0;
        if(s.charAt(idx)>='1' && s.charAt(idx)<='9'){
            A= Solve(s,idx+1,dp);
        }
        if(s.charAt(idx)=='1'){
            if(idx+1 < s.length() && s.charAt(idx+1)>='0' && s.charAt(idx+1)<='9'){
                B= Solve(s,idx+2,dp);
            }
        }
        if(s.charAt(idx)=='2'){
            if(idx+1< s.length() && s.charAt(idx+1)>='0' && s.charAt(idx+1)<='6'){
                C= Solve(s,idx+2,dp);
            }
        }

        return dp[idx] = A+B+C;

    }
}