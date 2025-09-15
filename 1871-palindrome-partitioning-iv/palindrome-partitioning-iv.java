class Solution {
    public boolean checkPartitioning(String s) {
        boolean [][] palindrome= new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            palindrome[i][i]=true;
        }
        int n=s.length();
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(len==2){
                    palindrome[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    palindrome[i][j]=palindrome[i+1][j-1] && s.charAt(i)==s.charAt(j);
                }
            }
        }
        for(int i=0;i<n-2;i++){
            if(!palindrome[0][i]) continue;
            for(int j=i+1;j<n-1;j++){
                if(palindrome[i+1][j] && palindrome[j+1][n-1]){
                    return true;
                }
            }
        }
        return false;
    }
}