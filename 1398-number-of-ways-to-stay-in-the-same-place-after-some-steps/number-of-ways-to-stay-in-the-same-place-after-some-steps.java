class Solution {
    int mod=1000000007;
    public int numWays(int steps, int arrLen) {
        int [][] dp= new int[501][steps+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return (int)(Solve(steps,0,0,arrLen,dp)%mod);
        
    }
    public  int Solve(int steps, int curr, int idx, int arrLen,int[][]dp){
        if(curr==steps){
            if(idx==0){
                return 1;
            }
            return 0;
        }
        if(idx<0 || idx>=arrLen){
            return 0;
        }
        if(dp[idx][curr]!=-1){
            return dp[idx][curr];
        }
        
        long stay=Solve(steps,curr+1,idx,arrLen,dp);
        long left=Solve(steps,curr+1,idx-1,arrLen,dp);
        long right=Solve(steps,curr+1,idx+1,arrLen,dp);

        return dp[idx][curr]= (int)((stay+left+right)%mod);
    }
}