class Solution {

    public int countHousePlacements(int n) {
        long [] dp= new long[n];
        Arrays.fill(dp,-1);
        long ans= Solve(0,n,dp);
        return (int)((long)(ans*ans)%1000000007);
    }
    public long Solve(int idx, int n,long[]dp){

        if(idx>=n){
            return 1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        
        long place=Solve(idx+2,n,dp);
        long notPlace=Solve(idx+1,n,dp);

        return dp[idx]=(place+notPlace)%1000000007;
    }
}