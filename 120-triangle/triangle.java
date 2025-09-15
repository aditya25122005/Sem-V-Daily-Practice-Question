class Solution {
    public int minimumTotal(List<List<Integer>> ll) {
        int n= ll.size();
        int idx=0;
        int sum=0;
        int [][] dp= new int[n][n];
        for(int [] a:dp){
            Arrays.fill(a,Integer.MAX_VALUE);
        }

        return Sum(ll,0,0,dp);


    }
    public static int Sum(List<List<Integer>> ll , int idx ,int row , int[][]dp){
        if(row==ll.size()-1){
            return ll.get(row).get(idx);
        }
        if(dp[row][idx]!=Integer.MAX_VALUE){
            return dp[row][idx];
        }
        int f=Sum(ll,idx,row+1,dp);
        int s=Sum(ll,idx+1,row+1,dp);
        return dp[row][idx]= Math.min(f,s) + ll.get(row).get(idx);
    }
}