class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int max=0;
        for(int num:dist){
            max=Math.max(max,num);
        }
        int lo=1;
        int hi=10000000;
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(dist, hour, mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] dist, double hours, double mid){
        double currTime=0;
        for(int i=0;i<dist.length;i++){
            double currT=(double)dist[i]/mid; // mid is speed
            currTime+=currT;
            if(currTime>hours) return false;
            currTime=(int)Math.ceil(currTime);
            

        }
        return true;
    }
}