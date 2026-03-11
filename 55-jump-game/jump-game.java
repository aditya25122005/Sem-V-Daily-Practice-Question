class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        if(nums.length==1 && nums[0]==0){
            return true;
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,i+nums[i]);
            if(i>=max) return false;
            if(max>=n-1){
                return true;
            }

        }
        return max>=n-1;
        

    }
    
}