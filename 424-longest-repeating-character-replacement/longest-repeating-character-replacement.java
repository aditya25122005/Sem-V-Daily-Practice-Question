class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map= new HashMap<>();
        int maxF = 0;
        int si=0;
        int ei=0;
        int ans=0;
        while(ei<s.length()){
            char ch = s.charAt(ei);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxF = Math.max(maxF, map.get(ch));

            if(ei-si+1-maxF>k){
                map.put(s.charAt(si), map.get(s.charAt(si))-1);
                if(map.get(s.charAt(si))==0){
                    map.remove(s.charAt(si));
                }
                si++;
            }
            ans=Math.max(ans,ei-si+1);
            ei++;

        }
        return ans;
    }
}