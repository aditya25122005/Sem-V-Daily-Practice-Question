class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        for(int i=0;i<nums1.length;i++){
            if(k!=0){
            if(Math.abs(nums1[i]-nums2[i])%k !=0){
                return -1;
            }
            }
        }
        long inc=0;
        long dec=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]>nums2[i]){
                if(k==0) return -1;
                inc += (nums1[i]-nums2[i])/k; // 1+1
            }
            else if(nums1[i]<nums2[i]){
                int diff= nums2[i]-nums1[i];
                if(k==0) return -1;
                dec+= diff/k;  //2
            }
        }
        if(inc==dec){
            return inc;
        }
        return -1;
    }
}