class Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> hh= new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            hh.add(s.charAt(i));
            if((i+1)%3==hh.size()){
                count++;
            }
        }
        return count;
    }
}