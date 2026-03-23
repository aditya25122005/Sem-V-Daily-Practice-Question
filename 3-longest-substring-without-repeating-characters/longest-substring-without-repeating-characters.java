class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();

        int si=0;
        int ei=0;
        int ans=0;
        int curr=0;
        HashSet<Character> hh= new HashSet<>();
        while(ei<n){
            char ch= s.charAt(ei);
            if(!hh.contains(ch)){
                hh.add(ch);
                ans=Math.max(ans,ei-si+1);
            }
            else{
            while(hh.contains(ch)){
                hh.remove(s.charAt(si));
                si++;
            }
            hh.add(s.charAt(ei));
            }
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}