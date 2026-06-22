class Solution {
    public int maxNumberOfBalloons(String text) {
        // b a l l o o n
        // HashMap<Character,Integer> map = new HashMap<>();
        int [] map = new int[26];
        for(char ch: text.toCharArray()){
            if(ch=='b' || ch=='a' || ch=='l' || ch=='o' || ch=='n')
            map[ch-'a']++;
        }
        if(map['l'-'a']==0 || map['l'-'a']<2) return 0;
        if(map['o'-'a']==0 || map['o'-'a']<2) return 0;
        if(map['n'-'a']==0)  return 0;
        if(map['b'-'a']==0) return 0;
        if(map['a'-'a']==0)  return 0;

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, map['l'-'a']/2);
        ans = Math.min(ans, map['o'-'a']/2);

        ans= Math.min(ans,map['a'-'a']);
        ans= Math.min(ans, map['n'-'a']);
        ans = Math.min(ans,map['b'-'a']);
        return ans;
    }
}