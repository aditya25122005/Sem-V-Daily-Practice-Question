class Solution {
    public int findPermutationDifference(String s, String t) {
        // HashMap<Character,Integer> map1= new HashMap<>();
        // HashMap<Character,Integer> map2= new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     map1.put(s.charAt(i),i);
        //     map2.put(t.charAt(i),i);
        // }
        // int ans=0;
        // for(char ch: s.toCharArray()){
        //     ans+= Math.abs(map1.get(ch)-map2.get(ch));
        // }
        // return ans;
        int ans=0;
        for(char ch:s.toCharArray()){
            int a=s.indexOf(ch);
            int b=t.indexOf(ch);
            ans+= Math.abs(a-b);
        }
        return ans;
       
    }
}