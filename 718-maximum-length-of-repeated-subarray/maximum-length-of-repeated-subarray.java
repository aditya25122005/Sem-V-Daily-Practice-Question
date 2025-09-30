class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp= new int [nums1.length][nums2.length];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        int ans=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                ans=Math.max(ans,Solve(nums1,nums2,i,j,dp));
            }
        }
        return ans;
    }
    public static int Solve(int [] arr1, int[] arr2, int i, int j, int[][] dp){
        if(i==arr1.length || j==arr2.length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(arr1[i]==arr2[j]){
            ans=1+Solve(arr1,arr2,i+1,j+1,dp);
        }
        return dp[i][j]=ans;
    }
}