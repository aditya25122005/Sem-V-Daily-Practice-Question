class Solution {
    public String sortVowels(String s) {
        String vowels="aeiouAEIOU";
        List<Character> ll= new ArrayList<>();
        for( char ch:s.toCharArray()){
            if(vowels.indexOf(ch)!=-1){
                ll.add(ch);
            }
        }
        Collections.sort(ll);


        int idx=0;
        StringBuilder res= new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            if(vowels.indexOf(s.charAt(i)) != -1 ){
                res.append(ll.get(idx));
                idx++;
            }
            else{
            res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}