class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        HashMap<Character,Integer> map1= new HashMap<>();
        for(char ch:word1.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> map2= new HashMap<>();
        for(char ch:word2.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        if(!map1.keySet().equals(map2.keySet())) return false;
        List<Integer>l1=new ArrayList<>();
        List<Integer>l2=new ArrayList<>();
        for(char key:map1.keySet()){
            l1.add(map1.get(key));
        }
        for(char key:map2.keySet()){
            l2.add(map2.get(key));
        }
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }
}