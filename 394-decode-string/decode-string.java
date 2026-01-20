class Solution {
    public String decodeString(String s) {
        StringBuilder ans= new StringBuilder();
        Stack<Integer> count= new Stack<>();
        Stack<StringBuilder> st= new Stack<>();
        st.push(new StringBuilder());
        count.push(1);
        int n= s.length();
        int i=0;

        while(i<n){
            char ch= s.charAt(i);
            
            if(Character.isDigit(ch)){
                int c=0;
                int freq=0;

                while(i<n && Character.isDigit(s.charAt(i))){
                    freq= freq*10 + s.charAt(i)-'0';
                    i++;
                }
                c= (freq==0)? 1: freq;
                count.push(c);
            }
            else if(ch=='['){
                st.push(new StringBuilder());
                i++;
                
            }
            else if(ch==']'){
                int repeat = count.pop();
                StringBuilder curr = st.pop();

                StringBuilder repeated= new StringBuilder();
                for(int j=1;j<=repeat;j++){
                    repeated.append(curr);
                }
                st.peek().append(repeated);
                i++;
            }
            else if(Character.isLetter(ch)){
                st.peek().append(ch);
                i++;
            }
        
            
        }
        return st.peek().toString();
    }
}