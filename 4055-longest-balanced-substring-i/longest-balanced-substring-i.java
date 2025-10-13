class Solution {
    public int longestBalanced(String s) {
        int maxlen=0;
        int n=s.length();

        for(int i=0;i<s.length();i++){
            int [] freq= new int[26];
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                freq[ch-'a']++;
                if(isBalanced(freq)){
                    maxlen=Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen;
    }
    public static boolean isBalanced(int[] freq){
        int find=0;
        for(int f:freq){
            if(f!=0){
                if(find==0) find=f;
                else if(f != find) return false;
            }
        }
        return true;
    }
}