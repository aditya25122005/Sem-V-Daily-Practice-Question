class Solution {
    public String shortestCompletingWord(String plate, String[] words) {
        plate= plate.toLowerCase();
        int[] freq= new int[26];
        for(char ch:plate.toCharArray()){
            if(Character.isLetter(ch)){
                freq[ch-'a']++;
            }
        }
        String ans=null;
        for(String s:words){
            int[] f= new int[26];
            for(char ch:s.toCharArray()){
                if(Character.isLetter(ch)){
                    f[ch-'a']++;
                }
            }
            boolean isValid=true;
            for(int i=0;i<26;i++){
                if(f[i]<freq[i]){
                    isValid=false;
                    break;
                }
            }
            if(isValid){
                if(ans==null || ans.length()>s.length()){
                    ans=s;
                }
            }
        }
        return ans;

    }
}