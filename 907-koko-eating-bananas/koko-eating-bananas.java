class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=0;
        int max=0;
        for(int num: piles){
            max=Math.max(max, num);
        }
        hi=max;
        int ans=hi;
        while(lo<=hi){
            int mid= lo+(hi-lo)/2;
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
    public static boolean isPossible(int [] piles, int H, int mid){
        int time=0;
        
        for(int i=0;i<piles.length;i++){
            if(piles[i]%mid==0){
                time+= piles[i]/mid;
            }
            else{
                time+= (piles[i]/mid)+1;
            }
            if(time>H) return false;
        }
        return time<=H;
    }
}