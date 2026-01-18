class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st= new Stack<>();
        int i=0;
        int j=0;
        while(i<pushed.length && j<popped.length){
            st.push(pushed[i]);
            i++;
            while(j<popped.length && !st.isEmpty() && st.peek()==popped[j]){
                st.pop();
                j++;
            }
        }
        if(i==pushed.length && j==popped.length){
            return true;
        }
        return false;
    }
}