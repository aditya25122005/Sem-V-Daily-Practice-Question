class Solution {
    public boolean doesAliceWin(String s) {
        if(vowelCount(s)==0){
            return false;
        }
        if(vowelCount(s)%2!=0){
            return true;
        }
        return true;
    }
    public static int vowelCount(String s){
        String vow="aeiou";
        int count=0;
        for(int i=0;i<s.length();i++){
            if(vow.indexOf(s.charAt(i))!=-1){
                count++;
            }
        }
        return count;
    }
}