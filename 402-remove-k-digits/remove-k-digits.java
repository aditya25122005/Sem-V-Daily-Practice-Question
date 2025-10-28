class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st= new Stack<>();
        for(char ch:num.toCharArray()){
            while(!st.isEmpty() && st.peek()> ch-'0' && k>0){
                st.pop();
                k--;
            }
            st.push(ch-'0');
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        String ans=sb.reverse().toString();
        int i=0;
        while(i<ans.length() && ans.charAt(i)=='0'){
                i++;
        }
        return ans.substring(i).equals("") ? "0" : ans.substring(i);
    }
}