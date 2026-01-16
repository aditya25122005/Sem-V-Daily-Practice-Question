class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // we take always nums1 as smallerst array to apply binary search on choosing no. of elements from nums1 
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length;
        int n=nums2.length;


        int lo=0; // take 0 elements from part 1 and ALL from part 2
        int hi=m; // take m elements from part 1 and rest from part 2
        // we have to apply binary search on , no. of elements chosen from shorter array

        while(lo<=hi){
            int cut1= lo+(hi-lo)/2; //No. of elements to take in LEFT part from nums1
            int cut2= (m+n+1)/2 - cut1;  // no. of elements to take in LEFT part from nums2
            // cut1+cut2 = half of the total elements (left part)
            /*
            nums1: [1, 3 | 8]
            nums2: [7, 9 | 10, 11]
             */

            // Largest element in left part of nums1
            int maxLeftA=(cut1==0)? Integer.MIN_VALUE : nums1[cut1-1];

            // smallest element in right part of nums1
            int minRightA= (cut1==m)?Integer.MAX_VALUE : nums1[cut1];

            // Largest element in left side of nums2
            int maxLeftB=(cut2==0)? Integer.MIN_VALUE : nums2[cut2-1];

            // smallest element in right side of nums2
            int minRightB=(cut2==n)? Integer.MAX_VALUE : nums2[cut2];


            if(maxLeftA <= minRightB && maxLeftB<= minRightA){
                if((m+n)%2==1){
                    return Math.max(maxLeftA,maxLeftB);
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