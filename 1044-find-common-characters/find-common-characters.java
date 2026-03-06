class Solution {
    public List<String> commonChars(String[] words) {
        int n= words.length;
        int[][] freq= new int[n][26];
        for(int i=0;i<words.length;i++){
            String s= words[i];
            for(char ch: s.toCharArray()){
                freq[i][ch-'a']++;
            }
        }
        List<String> ll= new ArrayList<>();
        for(int i=0;i<26;i++){
            int min=Integer.MAX_VALUE;
            char ch= (char)(i+97);
            for(int j=0;j<words.length;j++){
                min=Math.min(min, freq[j][i]);
            }

            for(int j=0;j<min;j++){
                ll.add(String.valueOf(ch));
            }
        }
        return ll;
    }
}