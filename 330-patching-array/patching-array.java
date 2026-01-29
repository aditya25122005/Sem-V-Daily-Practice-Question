class Solution {
    public int minPatches(int[] nums, int n) {
        long curr=0;
        int i=0;
        int patch=0;

        while(curr<n){
            if(i<nums.length && curr+1>=nums[i]){
            
                curr+= nums[i];
                i++;
            }
            else{
                patch++;
                curr= curr+(curr+1);
            }
        }
        return patch;
    }
}