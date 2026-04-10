class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /* 
            1,2,4,5
            3,6,7,8,9  
        */
        // Apply Binary Search on shorter Array TO Reduce Time Complexity
        if(nums2.length< nums1.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int n= nums1.length;
        int m= nums2.length;
        int half= (n+m+1)/2;

        // How many elements from Array 1 Will be on Left(Apply Binary Search On this)

        int lo=0;// No element from Arr 1 on left;
        int hi=n; // All elements from Arr1 On left;
        double ans=0;
        while(lo<=hi){
            int mid1=(lo+(hi-lo)/2);
            int mid2=half-mid1;

            int l1= mid1==0?Integer.MIN_VALUE : nums1[mid1-1];
            int l2= mid2==0?Integer.MIN_VALUE : nums2[mid2-1];

            int r1= mid1==n? Integer.MAX_VALUE : nums1[mid1];
            int r2= mid2==m? Integer.MAX_VALUE : nums2[mid2];

            if(l1<=r2 && l2<=r1){
                if((n+m)%2==0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }
                else{
                    return (double)Math.max(l1, l2);
                }
            }
            else if(l1>l2){
                hi=mid1-1;
            }
            else{
                lo=mid1+1;
            }
        }
        return 0.0;


    }
}