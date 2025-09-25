class Solution {
    public int minInsertions(String s) {
        int[][] dp= new int[s.length()][s.length()];
        for(int []a:dp){
            Arrays.fill(a,-1);
        }
        return Solve(s,0,s.length()-1,dp);
    }
    public static int Solve(String s, int i, int j, int [][]dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        
            if(s.charAt(i)!=s.charAt(j)){
                int r=1+Solve(s,i+1,j,dp);// added at right end
                int l=1+Solve(s,i,j-1,dp);// added at left end
                ans=Math.min(r,l);
            }else{
                ans=Solve(s,i+1,j-1,dp);
            }
            
        
        return dp[i][j]=ans;
    }
}