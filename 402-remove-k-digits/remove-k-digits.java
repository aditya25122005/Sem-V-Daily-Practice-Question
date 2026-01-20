class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<num.length();i++){
            int ch= num.charAt(i)-'0';
            while(!st.isEmpty() && k>0 && st.peek()>ch){
                k--;
                st.pop();
            }
            st.push(ch);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder ans= new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();
        String res= ans.toString();

        int idx=0;
        while(idx<res.length() && res.charAt(idx)=='0'){
            idx++;
        }
        
        return res.substring(idx).equals("")? "0": res.substring(idx);

    }
}