class Solution {
    List<String> res;
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        res= new ArrayList<>();
        Solve(words,groups,-1,0,new ArrayList<>());
        return res;
    }
    public void Solve(String[]words, int[]groups, int prev,int idx,List<String> ll){
        if(idx>=words.length){
            if(ll.size()>res.size()){
                res=new ArrayList<>(ll);
            }
            return;
        }
 
        if(prev==-1 || groups[idx]!=prev){
            ll.add(words[idx]);
            Solve(words,groups,groups[idx],idx+1,ll);
            ll.remove(words[idx]);

            Solve(words,groups,prev,idx+1,ll);
        }
        

    }
}