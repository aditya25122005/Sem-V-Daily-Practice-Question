class Solution {
    public String resultingString(String s) {
        Stack<Character> st= new Stack();
 
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            boolean removed=false;
            if(!st.isEmpty() && (Math.abs(ch-st.peek()) ==1 || Math.abs(ch-st.peek())==25)){
            st.pop();
            }
            else{
                st.push(ch);
            }
            
            
        }
        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}