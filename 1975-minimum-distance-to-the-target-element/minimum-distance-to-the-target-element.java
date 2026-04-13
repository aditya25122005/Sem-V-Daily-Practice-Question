class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int i= start;
        int j= start;
        while(i<nums.length && j>=0){
            if(nums[i]==target){
                return Math.abs(i-start);
            }
            else if(nums[j]==target){
                return Math.abs(j-start);
            }
            i++;
            j--;
        }
        while(i<nums.length){
            if(nums[i]==target){
                return Math.abs(i-start);
            }
            i++;
        }
         while(j>=0){
            if(nums[j]==target){
                return Math.abs(j-start);
            }
            j--;
        }
        

        return -1;
    }
}