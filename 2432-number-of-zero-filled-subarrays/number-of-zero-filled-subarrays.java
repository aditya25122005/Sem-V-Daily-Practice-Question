class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int cont=0;
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                cont++;
            }
            else{
                ans+= (long)cont*(cont+1)/2;
                cont=0;
            }
        }
        ans+= (long)cont*(cont+1)/2;
        return ans;
    }
}