class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ll= new ArrayList<>();
        HashMap<String,List<String>> map= new HashMap<>();
        for(String s: strs){
            String key = generateKey(s);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }
            else{
                map.put(key, new ArrayList<>());
                map.get(key).add(s);
            }

        }
        for(String key: map.keySet()){
            ll.add(map.get(key));
        }
        return ll;

    }
    public static String generateKey(String s){
        char [] arr= s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}