class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo=1;
        long max=Integer.MIN_VALUE;
        for(int num:time){
            max=Math.max(max,num);
        }
        long hi=(long)totalTrips*max;
        long ans=Long.MAX_VALUE;

        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isItPossible(time,mid,totalTrips)){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }

        }
        return ans;
    }
    public static boolean isItPossible(int [] time, long mid, int total){
        long trip=0;
        for(int t:time){
            trip+= mid/t;
            if(trip>=total) return true;
        }
        return false;
    }
}