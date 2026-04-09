class Solution {
    public int numberOfSubstrings(String s) {
        int n= s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int si=0;
        int ei=0;
        int count = 0;
        while(ei<s.length()){
            char ch = s.charAt(ei);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.containsKey('a') && map.containsKey('b') && map.containsKey('c')){
                map.put(s.charAt(si), map.get(s.charAt(si))-1);
                if(map.get(s.charAt(si))==0) map.remove(s.charAt(si));
                si++;
            }
            count+= si;
            ei++;
        }
        return count;
        
    }
}