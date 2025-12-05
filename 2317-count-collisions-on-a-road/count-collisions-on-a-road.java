class Solution {
    public int countCollisions(String directions) {
        Stack<Character> st= new Stack<>();
        int c=0;
        for(int i=0;i<directions.length();i++){
            char ch= directions.charAt(i);
            if(ch=='R'){
                st.push('R');
            }
            else if(ch=='S'){
                while(!st.isEmpty() && st.peek()=='R'){
                    c++;
                    st.pop();
                }
                st.push('S');
            }
            else if(ch=='L'){
                if(!st.isEmpty() && st.peek()=='R'){
                    c+=2;
                    st.pop();
                    while(!st.isEmpty() && st.peek()=='R'){
                        c++;
                        st.pop();
                    }
                    st.push('S');
                    
                }
                else if(!st.isEmpty() && st.peek()=='S'){
                    c++;
                    st.push('S');

                }
            }
        }
        return c;
    }
}