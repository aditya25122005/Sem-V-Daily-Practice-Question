class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        
        int[] ans= new int[nums.length];
        int e=0;
        int o=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                ans[e]= nums[i];
                e+=2;
            }
            else if(nums[i]%2==1){
                ans[o]=nums[i];
                o+=2;
            }
        }
        return ans;

    }
}