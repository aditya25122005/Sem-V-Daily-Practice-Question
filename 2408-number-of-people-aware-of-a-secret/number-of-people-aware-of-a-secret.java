class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long [] dp= new long[n+1];
        long share=0;
        long mod=(long)1000000007;
        dp[1]=1;
        long res=0;
        for(int i=2;i<=n;i++){
            dp[i]=share= (share+dp[Math.max(i-delay,0)]-dp[Math.max(i-forget,0)]+mod)%mod;
        }
        for(int i=n-forget+1;i<=n;i++){
            res=(res+dp[i])%mod;
        }
        return (int)res;
       

                                                                                                              
    }
}