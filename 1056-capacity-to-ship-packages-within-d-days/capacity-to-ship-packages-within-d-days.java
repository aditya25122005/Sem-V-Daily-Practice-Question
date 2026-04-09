class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo=0;
        int hi=0;
        for(int num: weights){
            hi+= num;
        }
        int ans=0;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(isPossible(weights, days,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int [] weights, int days, int capa){
        int used = 1;
        int sum=0;
        for(int num: weights){
            if(num>capa) return false;
            sum+=num;
            if(sum>capa){
                used++;
                sum=num;
            }
        }
        return used<=days;
    }
}