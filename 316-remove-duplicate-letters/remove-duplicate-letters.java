class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st= new Stack<>();
        int [] freq= new int [26];

        boolean [] seen= new boolean [26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        for(char ch:s.toCharArray()){
            freq[ch-'a']--;
            if(seen[ch-'a']) continue;
            while(!st.isEmpty() && st.peek()>ch && freq[st.peek()-'a']>=1){

                seen[st.peek()-'a']=false;
                st.pop();
                
            }

            st.push(ch);
            seen[ch-'a']=true;

        }
        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        for(int i=sb.length()-1;i>0;i--){
            if(sb.charAt(i)==sb.charAt(i-1) || freq[sb.charAt(i)-'a']>1){
                if(freq[sb.charAt(i)-'a'] >1){
                    freq[sb.charAt(i)-'a']--;
                    sb.deleteCharAt(i);
                }
            }
        }
        return sb.toString();
    }
}