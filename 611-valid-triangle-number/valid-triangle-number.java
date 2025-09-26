class Solution {
    public int triangleNumber(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=1;i--){
            int right=i-1;
            int left=0;
            while(left<right){
                if(nums[left]+nums[right]>nums[i]){
                    count+= (right-left);
                    right--;
                }
                else{
                    left++;
                }

            }
        }
        return count;
    }
}