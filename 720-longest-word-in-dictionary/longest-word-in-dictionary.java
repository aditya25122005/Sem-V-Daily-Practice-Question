class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> set= new HashSet<>();
        for(String st:words) set.add(st);
        String ans="";
        for(int i=words.length-1;i>=0;i--){
            String s=words[i];
            boolean isOK=true;

            for(int j=1;j<s.length();j++){
                if(!set.contains(s.substring(0,j))){
                    isOK=false;
                    break;
                }
            }
            if(isOK && s.length()>=ans.length()) ans=s; 

        }
        return ans;
    }
}