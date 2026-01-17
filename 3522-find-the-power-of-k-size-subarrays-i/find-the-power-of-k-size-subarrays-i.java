class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n= nums.length;
        int [] ans= new int[n-k+1];
        if(k==1){
            return nums;
        }
        Arrays.fill(ans,-1);
        int curr=1;
        
        for(int i=1;i<n;i++){
            if(nums[i]-1!=nums[i-1]){
                curr=1;
            }
            else{
                curr++;
                if(curr>=k){
                    ans[i-k+1]=nums[i];
                }
            }
        }
        return ans;
    }
}