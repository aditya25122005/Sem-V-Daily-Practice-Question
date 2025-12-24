class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String res="";
        for(int i=0;i<s.length();i++){
            for(int j=n-1;j>=0;j--){
                if((j-i+1)>res.length() && isPalindrome(s,i,j)){
                    res=s.substring(i,j+1);
                }
            }
        }   
        return res;
    }
    public static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}