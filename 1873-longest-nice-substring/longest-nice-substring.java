class Solution {
    public String longestNiceSubstring(String s) {
        int max=0;
        String res="";

        for(int i=0;i<s.length();i++){
            for(int j=i;j<=s.length();j++){
                if(isNice(s.substring(i,j))){
                    if(s.substring(i,j).length()>max){
                        res=s.substring(i,j);
                        max=s.substring(i,j).length();
                    }
                }
            }
        }
        return res;
    }
    public static boolean isNice(String s){
      
        for(char ch:s.toCharArray()){
            if(s.indexOf(Character.toUpperCase(ch))==-1 || s.indexOf(Character.toLowerCase(ch))==-1 ){
                return false;
            }
        }
        return true;
    }
}