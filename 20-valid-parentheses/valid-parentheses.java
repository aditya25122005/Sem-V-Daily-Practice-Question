class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else{
                if(!st.isEmpty() && isMatching(ch, st.peek())){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        
        return st.isEmpty();
    }
    public static boolean isMatching(char a, char b){
        if(a==')' && b=='(') return true;
        if(a=='}' && b=='{') return true;
        if(a==']' && b=='[') return true;
        return false;
    }
}