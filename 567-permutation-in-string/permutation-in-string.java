class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int [] f1= new int[26];
        for(char ch:s1.toCharArray()) f1[ch-'a']++;
        int [] f2= new int[26];
        int si=0;
        int ei=0;
        while(ei<s2.length()){
            char ch=s2.charAt(ei);
            f2[ch-'a']++;
            if(ei-si+1==s1.length()){
                if(isOk(f1,f2)) return true;
                f2[s2.charAt(si)-'a']--; // Remove that character
                si++;
            }
            ei++;

        }
        return false;
    }
    public static boolean isOk(int[] f1, int [] f2){
        for(int i=0;i<f1.length;i++){
            if(f1[i]!=f2[i]){
                return false;
            }
        }
        return true;
    }
}