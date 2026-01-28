class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        int n= s.length();
        boolean[][] isPalindrome= new boolean[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j= i+len-1;
                if(j-i<=2 && s.charAt(i)== s.charAt(j)){
                    isPalindrome[i][j]=true;
                }
                else if(s.charAt(i) != s.charAt(j)){
                    isPalindrome[i][j]= false;
                }
                else{
                    isPalindrome[i][j]= isPalindrome[i+1][j-1];
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isPalindrome[i][j]){
                    if(j-i+1>ans.length()){
                        ans= s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }
}