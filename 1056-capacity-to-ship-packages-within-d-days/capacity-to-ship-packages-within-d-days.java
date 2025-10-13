class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int max=0;
        for(int num:weights){
            max=Math.max(max,num);
            sum+=num;
        }
        int lo=max;
        int hi=sum;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(weights,days,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] weights, int days, int mid){
        int curr=0;
        int day=1;
        for(int num:weights){
            curr+=num;
            if(curr>mid){
                day++;
                curr=num;
                if(day>days) return false;
            }
            
        }
        return true;
    }
}