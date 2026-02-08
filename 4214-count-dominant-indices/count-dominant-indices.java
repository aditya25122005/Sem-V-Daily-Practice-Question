class Solution {
    public int dominantIndices(int[] nums) {
        int total=0;
        int c=0;
        for(int i=0;i<nums.length;i++){
            total+= nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            total-= nums[i];
            int avg = total/(nums.length-i-1);
            if(nums[i]>avg){
                c++;
            }
        }
        return c;
    }
}