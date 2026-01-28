class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        List<String> ll= new ArrayList<>();
        Solve(s,0,ans,ll);
        return ans;


    }
    public static void Solve(String s, int idx,  List<List<String>> ans, List<String> ll){
        if(idx==s.length()){
            ans.add(new ArrayList<>(ll));
            return;
        }

        for(int cut=idx+1;cut<= s.length(); cut++){
            if(isPalindrome(s,idx,cut)){
                ll.add(s.substring(idx,cut));
                Solve(s,cut,ans,ll);

                ll.remove(ll.size()-1);
            }
            // else{
            //     Solve(s,idx+1,ans,ll);
            // }
        }
    }
    public static boolean isPalindrome(String s, int i, int j){
        while(i<j-1){
            if(s.charAt(i)!= s.charAt(j-1)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}