class Solution {
    public String maxValue(String n, int x) {
        
        if(n.charAt(0)!='-'){
            boolean dalldiya= false;
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<n.length();i++){
                if( !dalldiya && (n.charAt(i)-'0')<x ){
                    sb.append(x);
                    dalldiya=true;
                }

                sb.append(n.charAt(i));
                
            }
            if(!dalldiya) sb.append(x);
            return sb.toString();
        }
        else{
            String s= n.substring(1);
            StringBuilder sb= new StringBuilder();
            sb.append('-');
            boolean dalldiya=false;
            for(int i=0;i<s.length();i++){
                if(!dalldiya && x<s.charAt(i)-'0'){
                    sb.append(x);
                    dalldiya=true;
                }
                sb.append(s.charAt(i));
            }
            if(!dalldiya){
                sb.append(x);
            }
            return sb.toString();
        }
    }
}