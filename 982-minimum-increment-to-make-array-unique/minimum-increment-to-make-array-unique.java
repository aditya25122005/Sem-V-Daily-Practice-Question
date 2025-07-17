class Solution {
    public int minIncrementForUnique(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=max){
                count+= max-nums[i]+1;
                max+=1;
            }
            else{
                max=nums[i];
            }
        }
        return count;
    }
}