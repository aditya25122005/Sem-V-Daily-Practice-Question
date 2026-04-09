class Solution {
    public int findPeakElement(int[] nums) {
        int lo=0;
        int hi = nums.length-1;
        int n= nums.length;
        int ans=-1;
        while(lo<=hi){
            int mid= lo+(hi-lo)/2;
            if((mid==0 || nums[mid-1]<nums[mid]) && (mid==n-1 || nums[mid+1]<nums[mid])){
                ans=mid;
                return mid;
                
            }
            else if(nums[mid]<nums[mid+1]){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;
    }
}