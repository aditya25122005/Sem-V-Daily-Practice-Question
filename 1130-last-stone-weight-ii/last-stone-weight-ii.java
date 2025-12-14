class Solution {
    public int lastStoneWeightII(int[] stones) {
        int[][]dp= new int[stones.length][3000];
        for(int [] D:dp){
        Arrays.fill(D,-1);
        }

        return Solve(stones,0,0,0,dp);
    }
    public static int Solve(int[] arr, int i, int j, int idx, int[][]dp){
        if(idx==arr.length){
            return Math.abs(i-j);
        }
        if(dp[idx][j]!=-1) return dp[idx][j];
 
        int a =Solve(arr,i+arr[idx],j,idx+1,dp);
        int b = Solve(arr,i,j+arr[idx],idx+1,dp);
        return dp[idx][j] = Math.min(a,b);
    }
}