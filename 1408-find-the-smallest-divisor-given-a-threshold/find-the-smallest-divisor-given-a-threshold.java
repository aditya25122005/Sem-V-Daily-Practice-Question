class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int lo=1;
        int hi=max;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(nums,threshold,mid)){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
        
    }
    public static boolean isPossible(int[] nums, int k, int mid){
        int curr=0;
        for(int i=0;i<nums.length;i++){
            double a=(double)nums[i]/mid;
            curr+= (int)Math.ceil(a);
        }
        return curr<=k;
    }
}