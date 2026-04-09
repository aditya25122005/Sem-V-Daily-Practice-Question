class Solution {
    public int splitArray(int[] nums, int k) {
        int lo=Integer.MAX_VALUE;
        int hi=0;
        for(int num: nums){
            lo=Math.min(lo,num);
            hi+= num;
        }
        int ans=0;
        while(lo<=hi){
            int mid= lo+(hi-lo)/2;
            if(isPossible(nums,k,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int []nums, int k, int mid){
        int curr = 0;
        int segment = 1;
        int i=0;
        while(i<nums.length){
            if(nums[i]> mid) return false;
            curr+= nums[i];
            if(curr>mid){
                segment++;
                curr = nums[i];
                if(segment>k) return false;
            }
            i++;
        }
        return segment<=k;
    }
}