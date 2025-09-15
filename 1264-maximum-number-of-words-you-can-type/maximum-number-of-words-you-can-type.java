class Solution {
    public int canBeTypedWords(String text, String broken) {
        String [] arr= text.split(" ");
        int count=arr.length;
        for(String word:arr){
            for(int i=0;i<word.length();i++){
                if(broken.indexOf(word.charAt(i)) != -1){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}