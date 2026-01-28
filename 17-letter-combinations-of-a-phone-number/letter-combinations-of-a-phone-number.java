class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans= new ArrayList<>();
        String [] arr= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        Solve(digits,arr,ans,"");
        return ans;
    }
    public static void Solve(String s, String [] arr, List<String> ans, String sb){
        if(s.length()==0){
            ans.add(sb);
            return;
        }
        char ch= s.charAt(0);
        String ques= s.substring(1);
        String curr= arr[ch-'0']; // abc
        for(int i=0;i<curr.length();i++){
            Solve(ques,arr,ans,sb+curr.charAt(i));
        }
    }
}