class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char ch: t.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> map= new HashMap<>();

        int si=0;
        int ei=0;
        int matched = 0;
        int ansSt=-1;
        int ansEnd = -1;
        int ansLen=Integer.MAX_VALUE;
        while(ei<s.length()){
            
            char ch = s.charAt(ei);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(freq.containsKey(ch) && map.get(ch)<= freq.get(ch)){
                matched++;
            }

            while(matched==n){
                if(ei-si+1 < ansLen){
                    ansSt = si;
                    ansEnd = ei;
                    ansLen= ei-si+1;
                }

                map.put(s.charAt(si), map.get(s.charAt(si))-1);
                // if(map.get(s.charAt(si))==0) map.remove(s.charAt(si));

                if(freq.containsKey(s.charAt(si)) && map.get(s.charAt(si))< freq.get(s.charAt(si))){
                    matched--;
                }
                si++;
            }
            ei++;
        }
        if(ansSt ==-1) return "";
        return s.substring(ansSt, ansEnd+1);
    }
    // public static boolean isValid(HashMap<Character,Integer> map, HashMap<Character,Integer> freq){
    //     for(char ch: freq.keySet()){
    //         if(!map.containsKey(ch)) return false;
    //         if(map.get(ch)< freq.get(ch)) return false;
    //     }
    //     return true;
    // }
}