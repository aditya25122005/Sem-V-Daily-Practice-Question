class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n= piles.length;
        Arrays.sort(piles);
        if(h==piles.length){
            return piles[n-1];
        }

        int lo=1;
        int hi=piles[n-1];
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(piles,h,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }

        }
        return ans;
    }
    public static boolean isPossible(int[]piles, int h, int mid){
        int c=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]<=mid){
                c++;
            }
            else{
                c+=(int)( Math.ceil((double)piles[i]/mid));
            }
            if(c>h){
                return false;
            }
        }
        if(c<=h){
            return true;
        }
        else{
            return false;
        }
    }
}