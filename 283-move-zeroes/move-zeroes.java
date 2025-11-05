class Solution {
    public void moveZeroes(int[] nums) {
        int shift=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                shift++;
            }
            else{
                int temp=nums[i];
                nums[i]=0;
                nums[i-shift]=temp;
                
            }
        }
    }
}