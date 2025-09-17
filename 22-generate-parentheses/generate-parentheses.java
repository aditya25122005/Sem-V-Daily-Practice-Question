class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll= new ArrayList<>();
        Solve(n,0,0,ll,"");
        return ll;
    }
    public static void Solve(int n,int open, int close, List<String>ll, String ans){
        if(open>n || close>open){
            return;
        }
        if(open==n && close==n){
            ll.add(ans);
            return;
        }
        Solve(n,open+1,close,ll,ans+'(');
        Solve(n,open,close+1,ll,ans+')');
    }
}