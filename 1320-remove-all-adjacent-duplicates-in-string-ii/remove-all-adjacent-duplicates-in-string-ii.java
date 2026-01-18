class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st= new Stack<>();
        for(char ch:s.toCharArray()){
            if(!st.isEmpty() && st.peek().c==ch){
                Pair pp= st.pop();
                int old=pp.freq;
                st.push(new Pair(ch,old+1));

                if(st.peek().freq==k){
                    st.pop();
                }
            }
            else{
                st.push(new Pair(ch,1));
            }
        }

        StringBuilder sb= new StringBuilder();
        for(Pair p: st){
            int freq=p.freq;
            char ch= p.c;
            for(int i=0;i<freq;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    
    }
    class Pair{
        char c;
        int freq;

        public Pair(char c, int freq){
            this.c=c;
            this.freq=freq;

        }
    }
}