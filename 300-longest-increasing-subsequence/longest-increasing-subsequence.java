class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] arr =new int [nums.length];
        arr[0]=nums[0];
        int ans=1;
        int last = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] > arr[ans-1]){
                arr[ans] = nums[i];
                ans++;
            }
            else{
                int idx = findIdx(arr,nums[i],ans-1);
                arr[idx] = nums[i];
            }
        }
        return ans;
    }

    public static int findIdx(int [] arr,int item, int hi){
        int lo=0;
        int ans=-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]<item){
                ans = mid;
                lo=mid+1;
            }
            else{
                 hi=mid-1;
            }
        }
        return ans+1;
    }
}