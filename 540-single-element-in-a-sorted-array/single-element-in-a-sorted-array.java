class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(mid%2==1){// stands at ending of a pair if any
                mid--;
            }
            if(nums[mid]!=nums[mid+1]){
                hi=mid;
            }
            else{
                lo=mid+2;
            }

        }
        return nums[lo];
    }
}