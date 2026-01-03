class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int [][] arr= new int[profit.length][3];
        int[] dp= new int[profit.length];
        Arrays.fill(dp,-1);
        for(int i=0;i<profit.length;i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        return Solve(arr,0,dp);

    }
    public static int Solve(int[][] arr, int idx, int[] dp){
        if(idx==arr.length){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int lo=idx+1;
        int hi=arr.length-1;
        int ans=0;
        int i=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid][0]>= arr[idx][1]){
                i=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }

        if(i!=-1){
            ans=Solve(arr,i,dp);
        }
        int b=Solve(arr, idx+1,dp);

        return dp[idx] = Math.max(ans+arr[idx][2], b);
    }
}