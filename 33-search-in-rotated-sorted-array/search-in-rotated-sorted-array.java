class Solution {
    public int search(int[] nums, int target) {
        int n= nums.length;
        int lo=0;
        int hi=n-1;

        while(lo<=hi){
            int mid= lo+(hi-lo)/2;
            if(nums[mid]==target) return mid;
            if(nums[0]<=nums[mid]){
                if(target>=nums[0] && target<=nums[mid]){
                    hi=mid-1;
                }
                else{
                    lo=mid+1;
                }
            }
            else{
                if(target>=nums[mid] && target<=nums[hi]){
                    lo=mid+1;
                }
                else{
                    hi=mid-1;
                }
            }
        }
        return -1;
    }
}