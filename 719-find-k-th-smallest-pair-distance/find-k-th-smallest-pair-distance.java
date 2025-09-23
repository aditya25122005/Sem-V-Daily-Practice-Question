class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo=0;
        int hi=Math.abs(nums[nums.length-1]-nums[0]);
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int pairs=Count(nums,mid);
            if(pairs>=k){
               hi=mid-1;
            }else{
                lo=mid+1;
            }

        }
        return lo;
    }
    public int Count(int []arr, int mid){
        int si=0;
        int ei=0;
        int ans=0;
        while(ei<arr.length){
            while(arr[ei]-arr[si]>mid){
                si++;
            }
            ans+= (ei-si);
            ei++;

        }
        return ans;
    }
}