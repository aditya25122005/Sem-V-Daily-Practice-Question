class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int [][] dp= new int[events.length][k+1];
        for(int []A:dp){
            Arrays.fill(A,-2);
        }
        
        return Solve(events,0,k,0,dp);

    }
    public static int Solve(int[][] events, int idx, int k, int curr,int [][] dp){
        if(idx==events.length){
            return 0;
        }
        if(curr>=k){
            return 0;
        }
        if(dp[idx][curr] !=-2){
            return dp[idx][curr];
        }
        int lo=idx+1;
        int hi= events.length-1;
        int i=-1;
        int ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(events[mid][0]> events[idx][1]){
                i=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        if(i!=-1){
            ans= Solve(events,i,k,curr+1,dp);
        }
        int b= Solve(events,idx+1,k,curr,dp);

        return dp[idx][curr] = Math.max( ans+events[idx][2],b);

    }
}