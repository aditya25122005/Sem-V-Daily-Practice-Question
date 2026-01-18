class Solution {
    public String lexSmallestAfterDeletion(String s) {
        int [] freq= new int[26];
        int [] used= new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        Stack<Character> st= new Stack<>();
        for(char ch:s.toCharArray()){
            freq[ch-'a']--;
            while(!st.isEmpty() && st.peek()>ch && used[st.peek()-'a']-1+freq[st.peek()-'a']>=1){
                used[st.peek()-'a']--;
                st.pop();
            }
// aacc
            st.push(ch);
            used[ch-'a']++;

        }
        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        for(int i=sb.length()-1;i>0;i--){
            
            if(used[sb.charAt(i)-'a']>1){
                used[sb.charAt(i)-'a']--;
                sb.deleteCharAt(i);
            }
            else{
                break;
            }

        }
        return sb.toString();

    }
}