class Solution {
    public int minCost(int n, int[] cuts) {
        int [] arr= new int[cuts.length+2];
        arr[0]=0;
        arr[arr.length-1]= n;
        for(int i=0;i<cuts.length;i++){
            arr[i+1]=cuts[i];
        }
        Arrays.sort(arr);
        int N= arr.length;
        Integer[][] dp= new Integer[N][N];

        return Solve(arr,0,arr.length-1,dp);

    }
    public static int Solve(int [] arr, int i, int j,Integer[][] dp){
        if(j-i<=1){
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        for(int cut=i+1;cut<j;cut++){
            int cost = arr[j]-arr[i]+ Solve(arr,i,cut,dp)+ Solve(arr,cut,j,dp);
            ans=Math.min(ans,cost);
        }
        return dp[i][j] = ans;
    }
}