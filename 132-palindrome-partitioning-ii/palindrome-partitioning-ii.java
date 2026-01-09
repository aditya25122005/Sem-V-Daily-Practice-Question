class Solution {
    int n;
    boolean[][] isPalindrome;
    int dp[];
    public int minCut(String s) {
        n=s.length();
        dp= new int[n];
        Arrays.fill(dp,-1);
         isPalindrome= new boolean[n][n];
        for(int len=1;len<=s.length();len++){
            for(int i=0;i+len-1<n;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len<=2){
                        isPalindrome[i][j]=true;
                    }
                    else{
                        isPalindrome[i][j]=isPalindrome[i+1][j-1];
                    }
                }
            }
        }
        return minCutneeded(0);
    }
    public int minCutneeded(int i){
        if(i==n){
            return -1; // as we dont need cut for last remaining char
        }
        int ans=Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        for(int j=i;j<n;j++){
            if(isPalindrome[i][j]){
                ans=Math.min(ans,1+minCutneeded(j+1));
            }
        }
        return dp[i]=ans;
    }
}