class Solution {
    public int countPartitions(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+= num;
        }
        int curr=0;
        int e=0;
        for(int i=0;i<nums.length-1;i++){
            curr+= nums[i];
            if((curr- (sum-curr))%2==0 )e++;
        }
        return e;
    }
}