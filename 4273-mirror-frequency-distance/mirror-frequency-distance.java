class Solution {
    public int mirrorFrequency(String s) {
        HashSet<Character> vis= new HashSet<>();
        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int ans=0;
        for(char ch : s.toCharArray()){
            if(vis.contains(ch)) continue;
            vis.add(ch);
            char mirror='*';
            if(ch>='a' && ch<='z'){
                mirror = (char)('a'+'z'-ch);
            }
            else{
                mirror = (char)('0'+'9'-ch);
            }
            vis.add(mirror);
            int f1=map.get(ch);
            int f2=0;
            if(map.containsKey(mirror)){
                f2= map.get(mirror);
            }
            ans+= Math.abs(f1-f2);

        }
        return ans;
    }
}