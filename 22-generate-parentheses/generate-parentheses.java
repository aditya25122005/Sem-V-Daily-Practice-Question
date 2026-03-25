class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll= new ArrayList<>();
        Solve(n,0,0,"",ll);
        return ll;

    }
    public static void Solve(int n, int open, int close, String ans,List<String>ll){

        if(close>open || open>n){
            return;
        }
        if(ans.length()==2*n && open==close){
            ll.add(ans);
            return;
        }

        Solve(n,open+1,close,ans+'(',ll);
        Solve(n,open,close+1,ans+')',ll);
    }
}