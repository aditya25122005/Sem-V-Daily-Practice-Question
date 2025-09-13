class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ll = new ArrayList<>();
        List<String > l1= new ArrayList<>();
        Solve(s,0,ll,l1);
        return ll;
    }
    public static void Solve(String s, int idx, List<List<String>> ll, List<String>l1){
        if(s.length()==0){
            ll.add(new ArrayList<>(l1));
            return ;
        }
        for(int cut=1;cut<=s.length();cut++){
            String str=s.substring(0,cut);
            if(isPalindrome(str)){
                l1.add(str);
                Solve(s.substring(cut),idx,ll,l1);
                l1.remove(l1.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
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