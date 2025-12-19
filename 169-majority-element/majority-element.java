class Solution {
    public int majorityElement(int[] nums) {
        int maxi=nums[0];
        int curr=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==maxi){
                curr++;
            }
            else{
                curr--;
                if(curr<0){
                    maxi=nums[i];
                    curr=0;
                }
            }
        }
        return maxi;
    }
}