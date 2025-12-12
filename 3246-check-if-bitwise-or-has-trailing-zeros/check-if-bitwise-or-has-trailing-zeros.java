class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int c=0;
        for(int num:nums){
            if((num&1)%2==0){
                c++;
            }
            
        }
        return c>=2;
    }
}