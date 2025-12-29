class Solution {
    public int lengthOfLongestSubstring(String s) {
        int si=0;
        int ei=0;
        int ans=0;
        int curr=0;
        HashSet<Character> seen= new HashSet<>();
        while(ei<s.length()){
            while(seen.contains(s.charAt(ei))){
                seen.remove(s.charAt(si));
                si++;
            } 
            seen.add(s.charAt(ei));
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}