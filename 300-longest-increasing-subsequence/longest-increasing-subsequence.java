class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums);
    }

    public static int LIS(int[] arr){
        int[] dp= new int[arr.length];
        int len=1;
        dp[0]=arr[0];
        for(int i=1;i<dp.length;i++){
            if(arr[i]>dp[len-1]){
                dp[len]=arr[i];
                len++;
            }else{
                int idx=BinarySearch(dp,0,len-1,arr[i]);
                dp[idx]=arr[i];
            }
        }
        return len;
    }
    public static int BinarySearch(int[] dp, int lo, int hi,int item){
        
        int idx=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(dp[mid]>=item){
                idx=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return idx;
    }
}