class Solution {
    public int[] singleNumber(int[] nums) {
        int [] ans=new int[2];
        int idx=0;
        for(int i=0;i<nums.length;i++){
            boolean found=false;
            for(int j=0;j<nums.length;j++){
                if(i!=j && nums[i]==nums[j]){
                    found=true;
                    break;
                }
            }
            if(!found){
                ans[idx++]=nums[i];
                if(idx==2){
                    break;
                }
            }
        }
        return ans;
    }
}