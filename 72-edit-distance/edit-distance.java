class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp= new Integer[word1.length()][word2.length()];
        return Solve(0,0,word1,word2,dp);
    }
    public static int Solve(int i, int j, String word1, String word2,Integer[][] dp){
        if(i>= word1.length()){
            return word2.length()-j;
        }
        if(j>= word2.length()){
            return word1.length()-i;
        }
        if(dp[i][j] != null) return dp[i][j];

        int A=Integer.MAX_VALUE;
        int B=Integer.MAX_VALUE;
        int C=Integer.MAX_VALUE;
        if(word1.charAt(i)!= word2.charAt(j)){
            A= 1+ Solve(i+1,j,word1,word2,dp); // Delete
            B= 1+ Solve(i+1,j+1,word1,word2,dp); // Replace
            C= 1+ Solve(i,j+1,word1,word2,dp); // Insert
        }
        else{
            A= Solve(i+1,j+1,word1,word2,dp);
        }

        return dp[i][j] = Math.min(A,Math.min(B,C));
    }
}