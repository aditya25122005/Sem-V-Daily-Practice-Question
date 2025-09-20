class Solution {
    public int[] twoSum(int[] nums, int target) {
        int one=0;
        int two=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                     one=i;
                     two=j;
                    break;
                }
            }
            
        }
        return new int []{one,two};
        
        
    }
}