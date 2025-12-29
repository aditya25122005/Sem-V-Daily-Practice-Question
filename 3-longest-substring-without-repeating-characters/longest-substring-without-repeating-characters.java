class Solution {
    public int lengthOfLongestSubstring(String s) {
        int si=0;
        int ei=0;
        int ans=0;
        HashSet<Character> set= new HashSet<>();
        while(ei<s.length()){
           
                while(set.contains(s.charAt(ei))){
                    set.remove(s.charAt(si));
                    si++;
                }

                set.add(s.charAt(ei));
                ans=Math.max(ans,ei-si+1);
                ei++;

            
        }
        return ans;
    }
}