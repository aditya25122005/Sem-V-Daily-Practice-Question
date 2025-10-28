class Solution {
    public String getHappyString(int n, int k) {
        List<String> ll= new ArrayList<>();
        Create("abc",n,ll,"");
        Collections.sort(ll);
        if(ll.size()<k) return "";
        return ll.get(k-1);

    }
    public static void Create(String ques,int n,List<String> ll,String ans){
        if(ans.length()==n){
            ll.add(ans);
            return;
        }
        if(ans.length()>n){
            return;
        }
        
        for(int i=0;i<ques.length();i++){
            if(ans.isEmpty() || ans.charAt(ans.length()-1) != ques.charAt(i)){
                Create(ques,n,ll,ans+ques.charAt(i));
            }
        }

    }
}