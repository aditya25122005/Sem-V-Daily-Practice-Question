class Solution {
    public String smallestString(String s) {
        StringBuilder sb= new StringBuilder();
        int n=s.length();
        int si=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='a'){
                si=i;
                break;
            }
        }
        int ei=0;
        for(int i=si;i<s.length() && i>=0;i++){
            if(s.charAt(i)!='a'){
                ei=i;
            }
            else{
                break;
            }
        }
        if(si==-1){
            String res= s.substring(0,s.length()-1);
            res+= (char)(s.charAt(n-1)+25);
            return res;
        }
        for(int i=0;i<si;i++){
            sb.append(s.charAt(i));
        }
        for(int i=si;i<=ei;i++){
            sb.append((char)(s.charAt(i)-1));
        }
        for(int i=ei+1;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}