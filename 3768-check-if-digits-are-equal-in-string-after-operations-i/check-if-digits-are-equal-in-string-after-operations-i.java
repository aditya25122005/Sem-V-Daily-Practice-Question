class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<s.length()-1;i++){
                sb.append((s.charAt(i)-'0'  +s.charAt(i+1)-'0')%10);
            }
            s=sb.toString();
        }
        return isSame(s);
    }
    public static boolean isSame(String s){
        char c=s.charAt(0);
        for(char ch:s.toCharArray()){
            if(ch!=c){
                return false;
            }
        }
        return true;
    }
}
