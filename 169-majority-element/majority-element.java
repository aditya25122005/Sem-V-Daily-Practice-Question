class Solution {
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int v=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==ele) v++;
            else{
                v--;
                if(v==0){
                    v=1;
                    ele=nums[i];
                }
            }
        }
        return ele;
    }
}