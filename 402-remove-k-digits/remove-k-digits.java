class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st= new Stack<>();
        for(int i=0;i<num.length();i++){
            char ch= num.charAt(i);
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
        int idx=0;
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='0'){
                idx++;
            }
            else{
                return ans.toString().substring(idx);
            }
        }
        
        return "0";

    }
}