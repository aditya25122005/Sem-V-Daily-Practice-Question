class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        Integer[][] dp= new Integer[triangle.size()][triangle.get(n-1).size()];
        return Solve(triangle,0,0,dp);
    }
    public static int Solve(List<List<Integer>> ll, int i, int j,Integer[][] dp){
        if(i>=ll.size() || j>=ll.get(i).size()){
            return 0;
        }
        if(i==ll.size()-1){
            return ll.get(i).get(j);
        }
        if(dp[i][j] != null) return dp[i][j];
        int A= ll.get(i).get(j) + Solve(ll,i+1,j,dp);
        int B= ll.get(i).get(j) + Solve(ll,i+1,j+1,dp);

        return dp[i][j] = Math.min(A,B);


    }
}