class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb= new StringBuilder();
        Stack<Character> st= new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch=='('){
                if(!st.isEmpty()){
                    sb.append(ch);
                }
                st.push(ch);
            }
            else if(ch==')'){
                st.pop();
                if(!st.isEmpty()){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();

    }
}