class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> freq= new HashMap<>();
        for(char ch: p.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> map= new HashMap<>();
        List<Integer> ll= new ArrayList<>();
        int si=0;
        int ei=0;
        while(ei<s.length()){
            char ch= s.charAt(ei);
            map.put(ch,map.getOrDefault(ch,0)+1);

            if(ei-si+1==p.length()){
                if(isEqual(map,freq)){
                    ll.add(si);
                }
                int old= map.get(s.charAt(si));
                map.put(s.charAt(si),old-1);
                if(map.containsKey(s.charAt(si)) && map.get(s.charAt(si))==0){
                    map.remove(s.charAt(si));
                }
                si++;
            }
            ei++;
        } 
        return ll;
    }
    public static boolean isEqual(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
        if(map1.size()!=map2.size()){
            return false;
        }
        for(char ch: map1.keySet()){
            if(!map2.containsKey(ch)){
                return false;
            }
            if(!map1.get(ch).equals(map2.get(ch))){
                return false;
            }
        }
        return true;
    }
}