class Solution {
    int[][] palindrome;
    int[][] dp; // idx se n tak ki substring ko K parts me divide karne par cost
    int n;
    public int palindromePartition(String s, int k) {
        n=s.length();
        palindrome=new int[n][n];
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                palindrome[i][j]=palindrome[i+1][j-1]+(s.charAt(i)==s.charAt(j)? 0:1);
            }
        }
        dp= new int[n][k+1];
        for(int [] a:dp){
        Arrays.fill(a,-1);
        }
        return Solve(0,k);
    }
    public int Solve(int idx, int k){
        if(k==1){
            return  palindrome[idx][n-1];
        }
        if(dp[idx][k]!=-1){
            return dp[idx][k];
        }
        int ans=n;
        for(int i=idx;i<=n-k;i++){
            int cost=palindrome[idx][i]+Solve(i+1,k-1);
            ans=Math.min(ans,cost);
        }
        return dp[idx][k]=ans;
    }
}