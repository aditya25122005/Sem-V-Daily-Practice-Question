class Solution {
    public int majorityElement(int[] nums) {
        int vote = 1;
        int elem = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == elem){
                vote++;
            }
            else{
                vote--;
                if(vote<0){
                    elem = nums[i];
                    vote=1;
                }
            }
        }
        return elem;
    }
}