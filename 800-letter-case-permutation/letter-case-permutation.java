class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ll= new ArrayList<>();
        Solve(s,ll,0,"");
        return ll;

    }
    public static void Solve(String s, List<String> ll, int idx, String ans){
        if(idx==s.length()){
            ll.add(ans);
            ans="";
            return;
        }
        char ch=s.charAt(idx);
        if(Character.isDigit(s.charAt(idx))){
            
            Solve(s,ll,idx+1,ans+ch);
        }else{
            if(Character.isLowerCase(ch)){
                Solve(s,ll,idx+1,ans+Character.toUpperCase(ch));
            }
            else if(Character.isUpperCase(ch)){
                 Solve(s,ll,idx+1,ans+Character.toLowerCase(ch));
            }
            Solve(s,ll,idx+1,ans+ch);
        }
    }
}