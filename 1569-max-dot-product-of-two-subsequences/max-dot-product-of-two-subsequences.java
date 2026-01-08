class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        Integer[][] dp= new Integer[nums1.length][nums2.length];
        return Solve(nums1,nums2,0,0,dp);
    }
    public static int Solve(int[]nums1, int[]nums2, int i, int j,Integer[][]dp){
        if(i==nums1.length || j==nums2.length){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int B=0;
        int C=0;
        int D=0;
        int ans= nums1[i]*nums2[j];
      
        B = ans + Math.max(0,Solve(nums1,nums2,i+1,j+1,dp));
        C = Solve(nums1,nums2,i,j+1,dp);
        D = Solve(nums1,nums2,i+1,j,dp);

        int res= Math.max(Math.max(D,B),Math.max(C,ans));
        return dp[i][j]=res;

    }
}