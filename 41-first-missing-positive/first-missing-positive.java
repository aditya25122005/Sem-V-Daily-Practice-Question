class Solution {
    public int firstMissingPositive(int[] nums) {
        // -1,4,3,1
        // -1,1,3,4
        // 1,-1,3,4

        int n= nums.length;
        for(int i=0;i<nums.length;i++){
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                int x=nums[i];
                int temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[x-1]=temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return n+1;
    }
}