class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq= new int[26];
        int si=0;
        int ei=0;
        int maxF=0;
        int ans=0;
        while(ei<s.length()){
            char ch= s.charAt(ei);
            freq[ch-'A']++;


            maxF=Math.max(maxF,freq[ch-'A']);

            while((ei-si+1)-maxF >k){
                freq[s.charAt(si)-'A']--;
                si++;
            }
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}