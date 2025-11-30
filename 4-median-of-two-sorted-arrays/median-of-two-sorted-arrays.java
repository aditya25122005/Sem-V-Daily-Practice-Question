class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;
        int [] arr= new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                arr[k]=nums1[i];
                i++;
                k++;
            }
            else{
                arr[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<n){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        while(j<m){
            arr[k]=nums2[j];
            j++;
            k++;
        }
        if(arr.length%2==1){
            int idx=arr.length/2;
            return (double)arr[idx];
        }
        else{
            int a= arr.length/2;
            int b= a-1;
            return (double)(arr[a]+arr[b])/2;
        }

    }
}