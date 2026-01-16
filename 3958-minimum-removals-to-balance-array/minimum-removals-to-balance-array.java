class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums.length==1){
            return 0;
        }
        int maxRm= 0;
        int i=0;
        int j=0;
        while(i<nums.length){
            while(j<nums.length && nums[j]<=(long)k*nums[i]){
                j++;
            }
           maxRm=Math.max(maxRm, (j-i));
            i++;
        }
        return nums.length-maxRm;
    }
}