class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp= new int[word1.length()+1][word2.length()+1];
        for(int []a :dp){
            Arrays.fill(a,-1);
        }
        return Solve(word1,word2,0,0,dp);
    }
    public static int Solve(String s1, String s2, int i, int j, int[][] dp){
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=Solve(s1,s2,i+1,j+1,dp);
        }else{ // FOOD --> MONEY
            int D= Solve(s1,s2,i+1,j,dp); // OOD -> MONEY
            int I= Solve(s1,s2,i,j+1,dp); //FOOD -> ONEY
            int R= Solve(s1,s2,i+1,j+1,dp); // OOD ->ONEY
            ans=1+Math.min(D,Math.min(I,R));
        }
        return dp[i][j]=ans;
    }
}