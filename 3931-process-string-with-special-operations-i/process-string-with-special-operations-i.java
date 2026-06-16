class Solution {
    public String processStr(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch>='a' && ch<='z'){
                st.push(ch);
            }
            else if(ch=='*'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else if(ch=='#'){
                Stack<Character> ss = new Stack<>();
                for(char c: st){
                    ss.push(c);
                }
                for(char c: st){
                    ss.push(c);
                }
                st=ss;

            }
            else if(ch=='%'){
                Stack<Character> ss = new Stack<>();
                while(!st.isEmpty()){
                    ss.push(st.pop());
                }
                st=ss;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(char ch: st){
            sb.append(ch);
        }
        return sb.toString();
    }
}