class Solution {
    public String minWindow(String s, String t) {
        if(t.length()> s.length()) return "";
        HashMap<Character,Integer> freq= new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch= t.charAt(i);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }

        int si=0;
        int ei=0;
        int ansLen=Integer.MAX_VALUE;
        int ans_lo=0;
        int ans_hi=0; // indices for answer substring

        HashMap<Character,Integer> map= new HashMap<>();


        while(ei<s.length()){
            char ch= s.charAt(ei);
            if(freq.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(check(map,freq)){
                    int currLen= ei-si+1;
                    if(currLen<ansLen){
                        ansLen=currLen;
                        ans_lo=si;
                        ans_hi=ei+1;
                    }
                
                while(si<ei && (!freq.containsKey(s.charAt(si)) || map.get(s.charAt(si))> freq.get(s.charAt(si))) ){
                    char c= s.charAt(si);
                    if(map.containsKey(c)){
                        map.put(c,map.get(c)-1);
                    }
                    si++;

                    int curr= ei-si+1;
                    if(curr<ansLen){
                        ansLen=curr;
                        ans_lo=si;
                        ans_hi=ei+1;
                    }
                }
            }
        }
        ei++;
        }
        return s.substring(ans_lo,ans_hi);

    }

    public static boolean check(HashMap<Character,Integer> map,HashMap<Character,Integer> freq){
        if(freq.size() != map.size()){
            return false;
        }
        for(char key: freq.keySet()){
            if(map.get(key)< freq.get(key)){
                return false;
            }
        }
        return true;
    }
}