class Solution {
    public int minDistance(String word1, String word2) {
        //LCS
        int[][] dp= new int[word1.length()][word2.length()];
        for(int [] a: dp){
            Arrays.fill(a,-1);
        }
        int LCS= Solve(word1,word2,0,0,dp);
        return word1.length()-LCS + word2.length()-LCS;

    }
    public static int Solve(String s1, String s2, int i, int j, int[][] dp){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int opr=0;
        if(s1.charAt(i)==s2.charAt(j)){
            opr=1+Solve(s1,s2,i+1,j+1,dp);
        }else{
            int f=Solve(s1,s2,i,j+1,dp);
            int s=Solve(s1,s2,i+1,j,dp);
            int res=Math.max(f,s);
            opr=Math.max(opr,res);
        }
        return dp[i][j]=opr;
    }
}