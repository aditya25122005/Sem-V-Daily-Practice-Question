class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map= new HashMap<>();
        int si=0;
        int ei=0;
        int ans=0;
        int maxFreq=0;
        while(ei<s.length()){
            map.put(s.charAt(ei),map.getOrDefault(s.charAt(ei),0)+1);
            maxFreq= Math.max(maxFreq, map.get(s.charAt(ei)));

            if((ei-si+1)-maxFreq> k){
               int old = map.get(s.charAt(si));
               map.put(s.charAt(si),old-1);
                si++; 
            }
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}