class Solution {
    public boolean hasAllCodes(String s, int n) {
        HashSet<String> hh= new HashSet<>();
        for(int i=0;i+n<=s.length();i++){
            String sub= s.substring(i,i+n);
            hh.add(sub);
        }
        return hh.size()== (1<<n);
        // List<String> ll= new ArrayList<>();
        //  for(int i=0;i< (1<<n);i++){
        //     String st =Integer.toBinaryString(i);
        //     if(st.length()<n){
        //         int diff= n-st.length();
        //         StringBuilder sb= new StringBuilder();
        //         sb.append("0".repeat(diff));
        //         sb.append(st);
        //         st=sb.toString();
        //     }
        //     ll.add(st);
        // }
        // for(String st:ll){
        //     if(s.indexOf(st)==-1) return false;
        // }
        // return true;
    }
}