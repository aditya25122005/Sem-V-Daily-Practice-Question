class Solution {
    public int lengthOfLongestSubstring(String s) {
        return Solve(s);
    }
    public static int Solve(String s){
        int si=0;
        int ei=0;
        int ans=0;
        int curr=0;
        HashSet<Character> hh= new HashSet<>();
        while(ei<s.length()){
            char ch= s.charAt(ei);
            if(!hh.contains(ch)){
                hh.add(ch);
                curr++;
            }else{
                while(s.charAt(si)!=ch && si<=ei){    
                    hh.remove(s.charAt(si));     
                    si++;
                    curr--;
                }
                si++;
            }
            ans=Math.max(ans,curr);
            ei++;
        }
        return ans; 
    }
   
}