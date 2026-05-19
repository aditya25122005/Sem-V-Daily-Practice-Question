class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] isPalindrome = new boolean[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j=i+len-1;
                if(len==1){
                    isPalindrome[i][j] = true;
                }
                else if(len==2 && s.charAt(i)==s.charAt(j)){
                    isPalindrome[i][j] = true;
                }
                else if(s.charAt(i) != s.charAt(j)){
                    isPalindrome[i][j] = false;
                }
                else{
                    isPalindrome[i][j] = isPalindrome[i+1][j-1];
                }

            }
        }
        String ans = "";
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int len = j-i+1;
                if(isPalindrome[i][j]){
                    if(len>ans.length()) ans = s.substring(i,j+1);
                }
            }
        }
        return ans;

    }
}