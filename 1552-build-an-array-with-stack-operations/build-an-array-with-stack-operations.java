class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> st= new Stack<>();
        List<String> ll= new ArrayList<>();
        int idx=0;

        for(int i=1;i<=n;i++){
            st.push(i);
            ll.add("Push");

            if(st.peek() != target[idx]){
                ll.add("Pop");
                st.pop();
            }
            else{
                idx++;
                if(idx==target.length){
                    break;
                }
            } 
        }
        return ll;


    }
}