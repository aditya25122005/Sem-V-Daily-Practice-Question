class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ll= new ArrayList<>();
        List<String> inner= new ArrayList<>();
        Solve(s,0,ll,inner);
        return ll;
    }
    public static void Solve(String s, int idx, List<List<String>> ll, List<String> inner){
        if(idx==s.length()){
            ll.add(new ArrayList<>(inner));
            return;
        }
        for(int cut=idx+1;cut<=s.length();cut++){
            if(isPalindrome(s,idx,cut-1)){
                inner.add(s.substring(idx,cut));
                Solve(s,cut,ll,inner);
                inner.remove(inner.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;

            }
            i++;
            j--;
        }
        return true;
    }
}