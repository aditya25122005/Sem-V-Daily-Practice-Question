class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=ages.length;
        int[][] arr= new int[n][2];
        int idx=0;
        for(int i=0;i<n;i++){
            arr[i][0]=scores[idx];
            arr[i][1]=ages[idx];
            idx++;
        }
        Arrays.sort(arr,(a,b)->a[1]==b[1]? a[0]-b[0] : a[1]-b[1]);
        int[][] dp= new int[n+1][n+2];
        for(int[]A:dp){
            Arrays.fill(A,-1);
        }
        return Solve(arr,0,-1,dp);
   
    }
    public static int Solve(int[][]arr, int idx, int pre, int[][]dp){
        if(idx==arr.length){
            return 0;
        }
        if(pre!=-1){
        if(dp[idx][pre]!=-1) return dp[idx][pre];
        }
        int a=0;

        if(pre==-1 || arr[idx][0]>=arr[pre][0]){
            a=arr[idx][0]+Solve(arr,idx+1,idx,dp);
        }
        int b=Solve(arr,idx+1,pre,dp);
        if(pre!=-1){
            dp[idx][pre]=Math.max(a,b);
        }

        return Math.max(a,b);
    }
}