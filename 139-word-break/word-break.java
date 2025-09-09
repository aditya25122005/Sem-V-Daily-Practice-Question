class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n= s.length();
        HashSet<String> hh= new HashSet<>(wordDict);
        int maxlen=0;
        for(String word:wordDict){
            maxlen=Math.max(maxlen,word.length());
        }
        long [] dp= new long [n];// 0 unvisited 1->Not Good 2-> Good
        return solve(s,0,hh,maxlen,dp);
    }
    public static boolean solve(String s,int idx,HashSet<String>hh,int maxlen, long[]dp){
        if(idx==s.length()){
            return true;
        }
        if(dp[idx]==2){
            return true;
        }
        if(dp[idx]==1){
            return false;
        }
        int endL=Math.min(idx+maxlen,s.length());
        for(int end=idx+1;end<=endL;end++){
            if(hh.contains(s.substring(idx,end)) && solve(s,end,hh,maxlen,dp)){
                dp[idx]=2;
                return true;
            }
        }
        dp[idx]=1;
        return false;
    }
}