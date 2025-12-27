class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long max=Long.MIN_VALUE;
        for(int num:time){
            max=Math.max(max,num);
        }
        long lo=1;
        long hi=(long)max*totalTrips;
        long ans=Long.MAX_VALUE;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isPossible(time,totalTrips,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[]time, int trips, long T){
        long currTrip=0;
        for(int i=0;i<time.length;i++){
            currTrip+= (T/time[i]);
            if(currTrip>=trips) return true;
        }
        if(currTrip>=trips) return true;
        return false;
    }
}