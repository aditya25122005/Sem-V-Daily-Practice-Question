class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int [] dp = new int[days.length];
        Arrays.fill(dp,-1);
        return Solve(days,0,costs,dp);
    }
    public static int Solve(int [] days, int idx, int [] cost, int [] dp){
        if(idx>=days.length){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int A=0;
        int B = 0;
        int C = 0;
        A = cost[0]+Solve(days,idx+1,cost,dp);
        int j=idx;
        while(j<days.length && days[j]<= days[idx]+6){
            j++;
        }
        B = cost[1]+ Solve(days,j,cost,dp);
        int k=idx;
        while(k<days.length && days[k]<= days[idx]+29){
            k++;
        }
        C =cost[2]+ Solve(days,k,cost,dp);
        return dp[idx] = Math.min(A,Math.min(B,C));

    }
}