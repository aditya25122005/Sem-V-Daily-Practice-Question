class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length< nums1.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int n= nums1.length;
        int m=nums2.length;

        int lo=0;
        int hi=n;
        while(lo<=hi){
            int cut1= lo+(hi-lo)/2;
            int cut2= (n+m+1)/2 -cut1;


            int left_Max_A= (cut1==0)?Integer.MIN_VALUE : nums1[cut1-1];
            int left_Max_B= (cut2==0)?Integer.MIN_VALUE : nums2[cut2-1];

            int right_Min_A= (cut1==n)? Integer.MAX_VALUE : nums1[cut1];
            int right_Min_B= (cut2==m)? Integer.MAX_VALUE : nums2[cut2];

            if(left_Max_A <= right_Min_B && left_Max_B <= right_Min_A){
                if((n+m)%2==1){
                    return Math.max(left_Max_A,left_Max_B);
                }
                else{
                    return (Math.max(left_Max_A, left_Max_B)+ Math.min(right_Min_A,right_Min_B))/2.0;
                }
            }
            else if(left_Max_A> right_Min_B){
                hi=cut1-1;
            }
            else{
                lo=cut1+1;
            }
        }
        return 0.0;
    }
}