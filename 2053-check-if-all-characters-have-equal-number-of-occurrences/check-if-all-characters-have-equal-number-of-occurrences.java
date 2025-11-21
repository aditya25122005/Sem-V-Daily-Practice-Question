class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        char ch= s.charAt(0);
        int a= map.get(ch);
        int prev=0;
        for(char key:map.keySet()){
           if(map.get(key)!=a){
            return false;
           }
        }
        return true;
    }

}