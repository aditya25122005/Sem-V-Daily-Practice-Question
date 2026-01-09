class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ll= new ArrayList<>();
        int prev=-1;
        for(int i=0;i<words.length;i++){
            if(prev!=groups[i]){
                prev=groups[i];
                ll.add(words[i]);
            }
        }
        return ll;
    }
}