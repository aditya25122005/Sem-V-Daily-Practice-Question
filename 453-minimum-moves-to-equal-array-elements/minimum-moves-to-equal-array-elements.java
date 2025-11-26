class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums) sum+=num;
        Arrays.sort(nums);
        return sum - n*nums[0];



    }
}