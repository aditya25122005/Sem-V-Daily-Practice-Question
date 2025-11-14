class Solution {
    public int removeElement(int[] nums, int val) {
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==val){
        //         i
        //     }
        // }

        int idx=0;
        int i=0;
        while(i<nums.length){
            if(nums[i]!=val){
                nums[idx]=nums[i];
                idx++;
                i++;
            }
            else{

                i++;
            }
        }
        return idx;
    }
}