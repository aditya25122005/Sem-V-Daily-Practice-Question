class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map= new HashMap<>();
        for(String s:strs){
            String sorted=sort(s);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
                map.get(sorted).add(s);
            }
            else{
                map.get(sorted).add(s);
            }
        }
        List<List<String>> ans= new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
    public static String sort(String s){
        StringBuilder sb= new StringBuilder();
        char[] arr= s.toCharArray();
        Arrays.sort(arr);
        for(char ch:arr){
            sb.append(ch);
        }
        return sb.toString();
    }
}