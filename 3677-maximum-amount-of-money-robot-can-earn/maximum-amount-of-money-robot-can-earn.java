class Solution {
    public int maximumAmount(int[][] coins) {
        Integer[][][] dp= new Integer[coins.length][coins[0].length][3];
        return Solve(0,0,coins,2,dp);
    }
    public static int Solve(int cr, int cc, int [][] coins, int K,Integer[][][] dp){
        if(cr>= coins.length || cc>= coins[0].length || K<0){
            return Integer.MIN_VALUE;
        }
    
        if(cr== coins.length-1 && cc== coins[0].length-1){
            if(K>0 && coins[cr][cc]<0){
                return 0;
            }
            return coins[cr][cc];
        }
        if(dp[cr][cc][K] != null) return dp[cr][cc][K];
        
        int ans=Integer.MIN_VALUE;

        if(coins[cr][cc]<0 && K>0){
            int next1= Solve(cr+1,cc,coins,K-1,dp);
            if(next1!=Integer.MIN_VALUE){
                ans=Math.max(ans,next1);
            }
            int next2=Solve(cr,cc+1,coins,K-1,dp);
            if(next2!=Integer.MIN_VALUE){
                ans=Math.max(ans,next2);
            }
        }
      
            int next3=Solve(cr+1,cc,coins,K,dp);
            if(next3!=Integer.MIN_VALUE){
                ans=Math.max(ans,coins[cr][cc] + next3);
            }
            int next4=Solve(cr,cc+1,coins,K,dp);
            if(next4!=Integer.MIN_VALUE){
                ans=Math.max(ans,coins[cr][cc]+ next4);
            }
        
        return dp[cr][cc][K] = ans;
    }   
}