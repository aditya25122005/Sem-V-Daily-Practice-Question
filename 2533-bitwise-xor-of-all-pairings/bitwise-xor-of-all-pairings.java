class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor=0;
        if(nums1.length%2==0 && nums2.length%2==1){
            for(int num:nums1){
                xor ^=num;
            }
            return xor;
        }
        else if(nums1.length%2==1 && nums2.length%2==0){
            for(int num:nums2){
                xor^= num;
            }
            return xor;
        }
        else if(nums1.length%2==0 && nums2.length%2==0){
            return 0;
        }
        else{
            for(int num:nums1){
                xor^=num;
            }
            for(int num:nums2){
                xor^=num;
            }
            return xor;
        }
    }
}