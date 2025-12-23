class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int c=0;

        for(char ch:t.toCharArray()){
            if(!map.containsKey(ch)){
                c++;
            }
            else{
                int old=map.get(ch);
                if(old==1){
                    map.remove(ch);
                }
                else{
                    map.put(ch,old-1);
                }
            }
        }
        return c;

    }
}