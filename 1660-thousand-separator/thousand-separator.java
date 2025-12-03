class Solution {
    public String thousandSeparator(int n) {
        String s= String.valueOf(n);
        if(s.length()<=3){
            return s;
        }
        int c=0;
        StringBuilder sb= new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
            c++;
            if(c==3){
                sb.append(".");
                c=0;
            }
        }
        String s2=sb.reverse().toString();
        if(s2.charAt(0)=='.'){
        return s2.substring(1,s2.length());
        }
        return s2.substring(0,s2.length());

    }
}