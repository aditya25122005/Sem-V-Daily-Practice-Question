class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hh= new HashSet<>();
        int si=0;
        int ei=0;
        int ans=0;
        while(ei<s.length()){
            char ch= s.charAt(ei);
            if(!hh.contains(ch)){
                hh.add(ch);
            }
            else{
                while(hh.contains(ch)){
                    hh.remove(s.charAt(si));
                    si++;
                }
                hh.add(ch);
            }
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}