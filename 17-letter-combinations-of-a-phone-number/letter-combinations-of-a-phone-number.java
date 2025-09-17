class Solution {
    static String[] keys={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {

        List<String> ll= new ArrayList<>();
        if(digits.equals("")) return ll;
        Solve(ll,digits,"");
        return ll;
    }
    public static void Solve(List<String> ll, String digits,String ans){
        if(digits.length()==0){
            ll.add(ans);
            return;
        }
        int di=digits.charAt(0)-'0';
        String key=keys[di];// abc
        for(int i=0;i<key.length();i++){
            char ch=key.charAt(i);
            Solve(ll,digits.substring(1),ans+ch);
        }
    }
}