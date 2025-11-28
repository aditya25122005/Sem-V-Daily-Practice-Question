class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans=1;
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int[][] dp= new int[n][m];
                for(int[]A:dp) Arrays.fill(A,-999);

                ans=Math.max(ans,Solve(matrix,i,j,dp));
            }
        }
        return ans;
    }
    public static int Solve(int[][] arr, int cr, int cc, int[][]dp){
        int n=arr.length;
        int m= arr[0].length;
        if(cr<0 || cr>=arr.length || cc<0 || cc>=arr[0].length || arr[cr][cc]==-1){
            return 0;
        }
        if(dp[cr][cc]!=-999){
            return dp[cr][cc];
        }
        int a=1;
        int b=1;
        int c=1;
        int d=1;

        if(cc<m-1){
            if(arr[cr][cc+1]>arr[cr][cc]){
                int temp=arr[cr][cc];
                arr[cr][cc]=-1;
                a=1+Solve(arr,cr,cc+1,dp);
                arr[cr][cc]=temp;
            }
        }
        if(cc>0){
            if(arr[cr][cc-1]>arr[cr][cc]){
                int temp=arr[cr][cc];
                arr[cr][cc]=-1;
                b=1+Solve(arr,cr,cc-1,dp);
                arr[cr][cc]=temp;
            }
        }
        if(cr>0){
            if(arr[cr-1][cc]>arr[cr][cc]){
                int temp=arr[cr][cc];
                arr[cr][cc]=-1;
                c=1+Solve(arr,cr-1,cc,dp);
                arr[cr][cc]=temp;
            }
        }
        if(cr<n-1){
            if(arr[cr+1][cc]>arr[cr][cc]){
                int temp=arr[cr][cc];
                arr[cr][cc]=-1;
                d=1+Solve(arr,cr+1,cc,dp);
                arr[cr][cc]=temp;
            }
        }
        return dp[cr][cc] = Math.max(Math.max(a,b),Math.max(c,d));
    }
}