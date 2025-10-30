class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0;i+minSize<=s.length();i++){
            String sub= s.substring(i,i+minSize);
            if(isGood(sub,maxLetters)){
                map.put(sub,map.getOrDefault(sub,0)+1);
            }
        }
        int max=0;
        for(String st:map.keySet()){
            max=Math.max(max,map.get(st));
        }
        return max;
    }
    public static boolean isGood(String s,int maxLetter){
        HashSet<Character> set= new HashSet<>();
        for(char ch:s.toCharArray()){
            set.add(ch);
        }
        if(set.size()<=maxLetter){
            return true;
        }
        return false;
    }
}