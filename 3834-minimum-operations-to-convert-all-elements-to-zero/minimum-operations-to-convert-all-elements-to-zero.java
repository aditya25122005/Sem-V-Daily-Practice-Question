class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st= new Stack<>();
        int opr=0;
        st.push(0);
        for(int num:nums){
            
            while(!st.isEmpty() && num<st.peek()){
                st.pop();
            }
            if(st.isEmpty() || num>st.peek()){
                if(num!=0){
                    opr++;
                }
                st.push(num);
            }
            
        }
        return opr;
    }
}