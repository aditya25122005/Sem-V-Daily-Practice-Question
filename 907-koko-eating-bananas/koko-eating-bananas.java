class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int lo=1;
        int hi=piles[piles.length-1];
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(piles,mid,h)<=h){ // mid ke corresponding hours
                ans=mid;
                hi=mid-1;
            }else if( isPossible(piles,mid,h)>h ){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return ans;
    }
    public static long isPossible(int[]piles, int curr, int h){
        long cnt=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]<=curr){
                cnt++;
            }else{
                cnt+=(long)Math.ceil((double)piles[i]/curr);
            }
        }
       return cnt;
    }
}