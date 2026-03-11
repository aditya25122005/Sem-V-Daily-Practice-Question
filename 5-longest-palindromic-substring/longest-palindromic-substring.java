class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(s.length()==1) return s;
        boolean [][] isPalindrome = new boolean [n][n];

        String ans = "";

        for(int len=1;len<=s.length();len++){
            for(int i=0;i+len-1<n;i++){
                int j=i+len-1;
                if(len <=2 && s.charAt(i)==s.charAt(j)){
                    isPalindrome[i][j]=true;
                }
                else if(s.charAt(i)!=s.charAt(j)){
                    isPalindrome[i][j]=false;
                }
                else{
                    isPalindrome[i][j] = isPalindrome[i+1][j-1]; 
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                int len= j-i+1;
                if(isPalindrome[i][j] && len>=ans.length()){
                    ans= s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}