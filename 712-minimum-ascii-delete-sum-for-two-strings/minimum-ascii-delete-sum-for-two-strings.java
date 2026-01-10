class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int [][] dp= new int[s1.length()][s2.length()];
        for(int []D:dp){
            Arrays.fill(D,-1);
        }
        return Solve(s1,s2,0,0,dp);
    }
    public static int Solve(String s1, String s2, int i, int j,int[][] dp){
        // if(i==s1.length() || j==s2.length()){
        //     return 0;
        // }
        if(i==s1.length()){
            int remainingSum=0;
            for(int k=j;k<s2.length();k++){
                remainingSum+= (int)(s2.charAt(k));
            }
            return remainingSum;
        }
        if(j==s2.length()){
            int remainingSum=0;
            for(int k=i;k<s1.length();k++){
                remainingSum+= (int)(s1.charAt(k));
            }
            return remainingSum;

        }
        if(dp[i][j] != -1) return dp[i][j];
        int A=0;
        int B=0;
        int C=0;
      
        if(s1.charAt(i)!=s2.charAt(j)){
            A =A+ ((int)(s2.charAt(j))) + Solve(s1,s2,i,j+1,dp); // delete from s2
            B =B+ ((int)(s1.charAt(i))) + Solve(s1,s2,i+1,j,dp); // delete from s1
            C =C+ ((int)(s1.charAt(i))) + ((int)(s2.charAt(j))) + Solve(s1,s2,i+1,j+1,dp); // delete from both
            return dp[i][j] = Math.min(A,Math.min(B,C));
        }
        else{
            return dp[i][j] = Solve(s1,s2,i+1,j+1,dp);
            
        }
        
    }
}