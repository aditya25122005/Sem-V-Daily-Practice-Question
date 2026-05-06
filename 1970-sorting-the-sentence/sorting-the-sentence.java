class Solution {
    public String sortSentence(String s) {
        String [] arr = s.split(" ");
        List<String> ll = new ArrayList<>();
        for(String str: arr){
            ll.add(str);
        }
        Collections.sort(ll,(a,b)->{
            return (a.charAt(a.length()-1)-'0') - (b.charAt(b.length()-1)-'0');
        });

        StringBuilder res = new StringBuilder();
        for(String st: ll){
            res.append(st.substring(0, st.length()-1));
            res.append(" ");
        }
        return res.toString().substring(0,res.length()-1);
    }
}