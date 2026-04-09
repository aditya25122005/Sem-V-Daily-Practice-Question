class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char ch:  s1.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> map= new HashMap<>();
        int si=0;
        int ei=0;
        int matched = 0;
        while(ei< s2.length()){
            char ch = s2.charAt(ei);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(ei-si+1 == s1.length()){
                if(isOk(freq,map)){
                    return true;
                }
                map.put(s2.charAt(si), map.get(s2.charAt(si))-1);
                if(map.get(s2.charAt(si))==0){
                    map.remove(s2.charAt(si));
                }
                si++;
            }
            ei++;
        }
        return false;
    }
    public static boolean isOk(HashMap<Character,Integer> freq, HashMap<Character,Integer> map){
        for(char ch: freq.keySet()){
            if(!map.containsKey(ch) || map.get(ch)<freq.get(ch)){
                return false;
            }
        }
        return true;
    }
}