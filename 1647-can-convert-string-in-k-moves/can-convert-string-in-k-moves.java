class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == t.charAt(i)) continue;
            int diff= (t.charAt(i) - s.charAt(i)+26)%26;
            
            int moveTime = diff+ (map.getOrDefault(diff,0)*26);
            if(moveTime> k){
                return false;
            }
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        return true;
    }
}