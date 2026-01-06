class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int [][][] dp= new int[n+1][minProfit+1][group.length];
        for(int [][]D:dp){
            for(int []A:D){
                Arrays.fill(A,-1);
            }
        }
        return Solve(group,profit,minProfit,n,0,0,0,dp);
    }
    public static int Solve(int [] group, int [] profit,int minProfit, int n, int currN, int currProfit,int idx,
    int[][][]dp){
        if(idx==group.length){
            if(currProfit>=minProfit) return 1;
            return 0;
        }
        if(dp[currN][currProfit][idx]!=-1) return dp[currN][currProfit][idx];
        long a=0;
        long b=0;
        if(currN+group[idx]<=n){    
            int newProfit=Math.min(minProfit,currProfit+profit[idx]);
            a+= Solve(group,profit,minProfit,n,currN+group[idx],newProfit,idx+1,dp);
        }
        b+= Solve(group,profit,minProfit,n,currN,currProfit,idx+1,dp);

        return dp[currN][currProfit][idx]=(int)(a+b)%1000000007;

    }
}