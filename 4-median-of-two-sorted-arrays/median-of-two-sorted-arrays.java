class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int n= nums1.length;
        int m=nums2.length;

        int lo=0;
        int hi=n;
        while(lo<=hi){
            int cut1= lo+(hi-lo)/2;
            int cut2= (n+m+1)/2 -cut1;


            int maxLeftA= cut1==0?Integer.MIN_VALUE: nums1[cut1-1];
            int minRightA = cut1==n?Integer.MAX_VALUE: nums1[cut1];
            int maxLeftB = cut2==0? Integer.MIN_VALUE: nums2[cut2-1];
            int minRightB = cut2==m? Integer.MAX_VALUE: nums2[cut2];

            if(maxLeftA<=minRightB && maxLeftB<= minRightA){
                // odd elements
                // Jo merged array banegi usme max element mid par hoga
                if((m+n)%2==1){
                    return Math.max(maxLeftA, maxLeftB);
                }
                else{
                    return (Math.max(maxLeftA,maxLeftB)+Math.min(minRightA,minRightB))/2.0;
                }
            }
            else if(maxLeftA>minRightB){
                hi=cut1-1;
            }
            else{
                lo=cut1+1;
            }


        }
        return 0.0;
    }
}