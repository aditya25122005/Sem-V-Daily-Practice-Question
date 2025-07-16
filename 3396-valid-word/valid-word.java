class Solution {
    public boolean isValid(String s) {
        if(s.length()<3){
            return false;
        }
        String s2=s.toLowerCase();
        for(int i=0;i<s2.length();i++){
            if(!Character.isDigit(s2.charAt(i)) && !(Character.isLetter(s2.charAt(i)))){
                return false;
            }
        }
        if(!checkVowelConsonant(s2)){
            return false;
        }
        return true;

    }
    public static boolean checkVowelConsonant(String s2){
        boolean vow=false;
        boolean cons=false;

        for(char ch:s2.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vow=true;
            }
            if(ch>='a' && ch<='z' && "aeiou".indexOf(ch)==-1){
                cons=true;
            }
            if(vow==true && cons==true){
                return true;
               
            }
        }
        return false;
    }
}