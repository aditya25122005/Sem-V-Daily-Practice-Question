class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        sort(nums1,nums2,m,n);
    }
    public static void sort(int[] nums1, int[] nums2, int m, int n){
        int i=m-1;
        int j=n-1;
        
        int idx=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[idx]=nums1[i];
                i--;
                idx--;
            }
            else{
                nums1[idx]=nums2[j];
                j--;
                idx--;
            }
           
        }
        while(idx>=0 && i>=0){
            nums1[idx]=nums1[i];
            i--;
            idx--;
        }
        while(idx>=0 && j>=0){
            nums1[idx]=nums2[j];
            j--;
            idx--;
        }
        
    }
}