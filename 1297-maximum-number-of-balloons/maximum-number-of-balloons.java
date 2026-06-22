class Solution {
    public int maxNumberOfBalloons(String text) {
        // b a l l o o n
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: text.toCharArray()){
            if(ch=='b' || ch=='a' || ch=='l' || ch=='o' || ch=='n')
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        if(!map.containsKey('l') || map.get('l')<2) return 0;
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, map.get('l')/2);
        if(!map.containsKey('o') || map.get('o')<2) return 0;
        ans = Math.min(ans,map.get('o')/2);

        if(!map.containsKey('n')) return 0;
        if(!map.containsKey('b')) return 0;
        if(!map.containsKey('a')) return 0;
       
        ans= Math.min(ans,map.get('a'));
        ans= Math.min(ans, map.get('n'));
        ans = Math.min(ans,map.get('b'));
        return ans;
    }
}