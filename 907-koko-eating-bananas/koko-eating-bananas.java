class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=0;
        for(int num: piles){
            hi= Math.max(hi, num);
        }
        int ans=0;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(isPossible(piles, h, mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int [] piles, int hour, int mid){
        int used=0;
        for(int num: piles){
            if(num<= mid) used++;
            else{
                used += (num/mid);
                if(num%mid != 0) used++;
            }
            if(used>hour) return false;
        }
        return used<=hour;
    }
}