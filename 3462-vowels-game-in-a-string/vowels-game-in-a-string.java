class Solution {
    public boolean doesAliceWin(String s) {
        int vc=vowelCount(s);
        if(vc==0){
            return false;
        }
        if(vc%2!=0){
            return true;
        }
        return true;
    }
    public static int vowelCount(String s){
        // String vow="aeiou";
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e'||s.charAt(i)=='i'|| s.charAt(i)=='o' || s.charAt(i)=='u'){
                count++;
            }
        }
        return count;
    }
}