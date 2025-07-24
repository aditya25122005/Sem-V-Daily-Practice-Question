class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr=s.split(" ");
        HashMap<Character,String>map= new HashMap<>();
        HashSet<String> used= new HashSet<>();
        int i=0;
        if(pattern.length() != arr.length) return false;
        for(char ch:pattern.toCharArray()){
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(arr[i])) return false;
            }
            else{
                if(used.contains(arr[i])) return false;
            map.put(ch,arr[i]);
            used.add(arr[i]);
            }
            i++;
        }
        return true;
    }
}