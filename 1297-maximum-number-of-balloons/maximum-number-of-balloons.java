class Solution {
    public int maxNumberOfBalloons(String s) {
        String target="balloon";
        HashMap<Character,Integer> map= new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> map2= new HashMap<>();
        for(char ch:target.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        for(char ch:target.toCharArray()){
            if(!map.containsKey(ch)) return 0;
            int copy=(int)(Math.floor(map.get(ch)/map2.get(ch)));
            ans=Math.min(ans,copy);
        }
       
        return ans;
    }
}