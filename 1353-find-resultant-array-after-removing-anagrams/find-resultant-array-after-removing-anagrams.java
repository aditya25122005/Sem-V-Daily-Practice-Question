class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ll= new ArrayList<>();
        int i=0;
        int j=1;
        ll.add(words[0]);
        while(i<words.length && j<words.length){
            if(isAnabelle(words[i],words[j])){
                j++;
            }
            else{
                ll.add(words[j]);
                i=j;
                j++;
            }
        }
        return ll;
    }
    public static boolean isAnabelle(String s1, String s2){
        HashMap<Character,Integer> map1= new HashMap<>();
        HashMap<Character,Integer> map2= new HashMap<>();
        for(char ch:s1.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch:s2.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        return map1.equals(map2);

    }
}