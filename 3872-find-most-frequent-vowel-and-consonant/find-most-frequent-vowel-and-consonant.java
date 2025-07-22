class Solution {
    public int maxFreqSum(String s) {
        int n=s.length();
        String vowel="aeiou";
        int maxvow=0;
        int maxcon=0;
        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char key:map.keySet()){
            if(vowel.indexOf(key)!=-1){
                int freq=map.get(key);
                if(freq>maxvow){
                    maxvow=freq;
                }
            }
        }
        for(char key:map.keySet()){
            if(vowel.indexOf(key)==-1){
                int freq=map.get(key);
                if(freq>maxcon){
                    maxcon=freq;
                }
            }
        }
        return maxvow+maxcon;
    }
}