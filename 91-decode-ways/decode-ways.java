class Solution {
    public int numDecodings(String s) {
        Integer [] memo= new Integer[s.length()];
        if(s.charAt(0)=='0') return 0;
        return Solve(s,0,memo);
    }
    public static int Solve(String s, int idx,Integer[] dp){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx]!=null) return dp[idx];
        
        char ch= s.charAt(idx);
        int A=0;
        if(ch=='0'){
            return 0;
        }
        if(ch!=0){
            A= Solve(s,idx+1,dp);
        }
        int B=0;
        if(ch=='0'){
            return 0;
        }
        if(s.charAt(idx)!='0' && idx<s.length()-1){
            int num= (s.charAt(idx)-'0')*10 + (s.charAt(idx+1)-'0');
            if(num>=10 && num<=26){
                B= Solve(s,idx+2,dp);
            }
           
        }

        return dp[idx] = A+B;

    }
}