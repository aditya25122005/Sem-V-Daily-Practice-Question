class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ll= new ArrayList<>();
        for(String s: queries){
            for(String w: dictionary){
                if(isOk(s,w)){
                    ll.add(s);
                    break;
                }
            }
        }
        return ll;
    }
    public static boolean isOk(String a, String b){
        int diff=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
                if(diff>2) return false;
            }
        }
        return true;
    }
}