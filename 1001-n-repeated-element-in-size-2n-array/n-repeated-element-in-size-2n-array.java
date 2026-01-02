class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> hh= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(hh.contains(nums[i])){
                return nums[i];
            }
            hh.add(nums[i]);
        }
        return 0;
    }
}