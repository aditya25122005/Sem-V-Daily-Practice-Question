class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp= new int[grid.length][grid[0].length];
        for(int [] a:dp){
            Arrays.fill(a,9999999);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            ans=Math.min(ans,Solve(grid,0,i,dp));
        }
        return ans;
    }
    public static int Solve(int[][] arr, int r, int c, int [][] dp){
        if(r==arr.length-1){
            return arr[r][c];
        }
        // if(c<0 || c>=arr[0].length){
        //     return Integer.MAX_VALUE;
        // }
        if(dp[r][c]!=9999999){
            return dp[r][c];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<arr[0].length;i++){
            if(i==c){
                continue;
            }
            ans=Math.min(ans,Solve(arr,r+1,i,dp));
        }
        return dp[r][c]=ans+arr[r][c];

    }
}