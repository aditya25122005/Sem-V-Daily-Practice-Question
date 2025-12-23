class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2= new HashMap<>();

        for(char ch:s.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int res=0;
        for(char key:map1.keySet()){
            int count1=map1.get(key);
            int count2=0;
            if(map2.containsKey(key)){
                count2=map2.get(key);
            }
            res+= Math.abs(count1-count2);
        }

        for(char key:map2.keySet()){
            if(!map1.containsKey(key)){
                res+= map2.get(key);
            }
        }
        return res;
    }
}