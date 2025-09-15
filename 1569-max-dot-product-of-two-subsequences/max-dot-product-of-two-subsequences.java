class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m= nums2.length;
        int[][] dp= new int[n][m];
        for(int [] a:dp){
            Arrays.fill(a,Integer.MIN_VALUE);
        }
        return DOT(nums1, nums2, 0,0,dp);
    }
    public static int DOT(int [] nums1, int[] nums2, int i, int j, int [][] dp){
        if(i==nums1.length || j== nums2.length){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int ans=nums1[i]*nums2[j]; // take only one pair
        int f= ans + Math.max(0,DOT(nums1, nums2, i+1, j+1,dp)); // continue add ing old value
        int s= DOT(nums1, nums2, i+1,j,dp); // skip this i and check for other pairs 
        int t= DOT(nums1, nums2, i,j+1,dp);  // skip this j ,,  ,,  ,,
        return dp[i][j]= Math.max(Math.max(ans,f),Math.max(s,t));  // Return max of all
        
    }
}