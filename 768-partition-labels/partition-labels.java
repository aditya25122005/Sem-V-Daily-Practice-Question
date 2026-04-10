class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map =new HashMap<>();
        for(int i=s.length()-1;i>=0;i--){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }
        }
        List<Integer> ans= new ArrayList<>();
        int currEnd=-1;
        int start=0;
        for(int i=0;i<s.length();i++){
            currEnd= Math.max(currEnd, map.get(s.charAt(i)));
            if(i==currEnd){
                ans.add(currEnd-start+1);
                start= i+1;
            }
        }
        return ans;
    }
}