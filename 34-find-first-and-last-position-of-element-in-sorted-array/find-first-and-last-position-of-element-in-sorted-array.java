class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans= new int[2];
        Arrays.fill(ans,-1);
        int i=0;
        for(int j=i;j<nums.length;j++){
            if(nums[j]==target){
                ans[0]=j;
                break;
            }
        }
        
        int l=nums.length-1;
        for(int j=l;j>=0;j--){
            if(nums[j]==target){
                ans[1]=j;
                break;
            }
        }
        return ans;
    }
}