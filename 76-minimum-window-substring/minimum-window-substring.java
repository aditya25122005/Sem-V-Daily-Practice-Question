class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> freq= new HashMap<>();
        for(char ch: t.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        int total= t.length();
        HashMap<Character,Integer> map= new HashMap<>();
        int si=0;
        int ei=0;
        int ansLen=Integer.MAX_VALUE;
        String ans="";
        while(ei<s.length()){
            char ch= s.charAt(ei);
            if(freq.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(check(freq,map)){
                    int curr= ei-si+1;
                    if(curr<ansLen){
                        ans=s.substring(si,ei+1);
                        ansLen=ans.length();
                    }
                    // ans= s.substring(si,ei+1);
                    while(si<ei && (!freq.containsKey(s.charAt(si)) || 
                    map.get(s.charAt(si))> freq.get(s.charAt(si)))){
                        char c= s.charAt(si);
                        if(map.containsKey(c)){
                        map.put(c,map.get(c)-1);
                        }
                        si++;
                        
                        curr=ei-si+1;
                        if(curr<ansLen){
                            ans=s.substring(si,ei+1);
                            ansLen=ans.length();
                        }
                    }
                }

            }
            ei++;
        }
        return ans;
    }
    public static boolean check(HashMap<Character,Integer> freq, HashMap<Character,Integer> map){
        if(freq.size()!= map.size()){
            return false;
        }
        for(char key: freq.keySet()){
            if(map.get(key)<freq.get(key)){
                return false;
            }
        }
        return true;
    }
}