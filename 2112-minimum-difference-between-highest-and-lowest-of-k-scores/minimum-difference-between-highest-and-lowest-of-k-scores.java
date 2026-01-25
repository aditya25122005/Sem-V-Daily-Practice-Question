class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n= nums.length;
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        int i=0;
        int j=k-1;
        while(i<=n-k && j<n){
            ans=Math.min(ans,nums[j]-nums[i]);
            i++;
            j++;
        }
        return ans;
    }
}