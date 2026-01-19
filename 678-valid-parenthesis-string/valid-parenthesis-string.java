class Solution {
    public boolean checkValidString(String s) {
        int n= s.length();
        Boolean [][][] dp= new Boolean[n][n+1][n+1];
     
        if(s.length()==1){
            if(s.charAt(0)=='*') return true;
            return false;
        }
        return Solve(s,0,0,0,dp);
    }
    public static boolean Solve(String s, int idx, int open, int close,Boolean[][][]dp){
        if(close>open || open>s.length()/2 || close>s.length()/2){
            return false;
        }
        if(idx==s.length()){
            if(open==close){
                return true;
            }
            return false;
        }
        if(dp[idx][open][close]!=null){
            return dp[idx][open][close];
        }
                
        boolean a= false;
        boolean b=false;
        boolean c=false;
        if(s.charAt(idx)=='('){
            a= Solve(s,idx+1,open+1,close,dp);
        }
        if(s.charAt(idx)==')'){
            b= Solve(s,idx+1,open,close+1,dp);
        }
        if(s.charAt(idx)=='*'){
            c= Solve(s,idx+1,open+1,close,dp) || 
                Solve(s,idx+1,open,close+1,dp) ||
                Solve(s,idx+1,open,close,dp);
        }
        return dp[idx][open][close] = (a|| b|| c);
    }
}