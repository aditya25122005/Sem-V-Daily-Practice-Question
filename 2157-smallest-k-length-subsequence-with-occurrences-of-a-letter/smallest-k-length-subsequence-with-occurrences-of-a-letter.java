class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int K=s.length()-k;
        // remove K characters from s
        //Try to leeave letter
        int total=0;
        int used=0;
        for(char ch: s.toCharArray()){
            if(ch==letter) total++;
        }
        Stack<Character> st= new Stack<>();
        for(char ch: s.toCharArray()){
            while(!st.isEmpty() && K>0 && st.peek()>ch){

                if(st.peek()==letter){
                    if(used-1+total<repetition) break; // cannot remove this
                    used--;
                }
                st.pop();
                K--;
            }
            st.push(ch);
            if(ch==letter){
                used++;
                total--;
            }
        }
      
        
        int c=0;
        StringBuilder ans= new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();


        int Len=k;
        int occ=repetition;
        StringBuilder res= new StringBuilder();
        for(int i=0;i<ans.length();i++){
            char ch= ans.charAt(i);
            if(ch==letter){
                res.append(ch);
                occ--;
            }
            else{
                if(Len-res.length()>occ){
                    res.append(ch);
                }
            }
            if(res.length()==k) break;
        }
        return res.toString();





    //     List<String> ll= new ArrayList<>();
    //     Solve(s,0,"",letter,0,repetition,k,ll);
    //     Collections.sort(ll);
    //     return ll.get(0);
    // }
    // public static void Solve(String s, int idx, String ans, char ch, int occ,int rept , int k,List<String> ll){
    //     if(occ>=rept && ans.length()==k){
    //         ll.add(ans);
    //         return;
    //     }
    //     if(idx>=s.length()){
    //         return;
    //     }
    //     if(s.charAt(idx)==ch){
    //         // take it
    //         Solve(s,idx+1,ans+s.charAt(idx),ch,occ+1,rept,k,ll);
    //         Solve(s,idx+1,ans,ch,occ,rept,k,ll);
    //     }
    //     else{
    //         Solve(s,idx+1,ans+s.charAt(idx),ch,occ,rept,k,ll);
    //         Solve(s,idx+1,ans,ch,occ,rept,k,ll);
    //     }

    }
}