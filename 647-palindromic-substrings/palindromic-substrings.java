class Solution {
    public int countSubstrings(String s) {
        int n= s.length();
        int c=0;
        boolean[][] isPalindrome= new boolean[n][n];

        for(int len=1;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j= i+len-1;
                if(s.charAt(i)!= s.charAt(j)){
                    isPalindrome[i][j]= false;
                }
                else if(j-i<=2 && s.charAt(i)==s.charAt(j)){
                    isPalindrome[i][j] = true;
                }
                else{
                    isPalindrome[i][j]= isPalindrome[i+1][j-1];
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isPalindrome[i][j]==true){
                    c++;
                }
            }
        }
        return c;
    }
}