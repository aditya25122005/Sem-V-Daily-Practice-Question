class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int k=0;
        int [] a= nums1.clone();
        while(i<m && j<n){
            if(a[i]<nums2[j]){
                nums1[k]=a[i];
                i++;
                k++;
            }
            else{
                nums1[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<m){
            nums1[k]=a[i];
            i++;
            k++;
        }
        while(j<n){
            nums1[k]=nums2[j];
            j++;
            k++;
        }
    }
}