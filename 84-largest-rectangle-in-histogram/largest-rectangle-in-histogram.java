class Solution {
    public int largestRectangleArea(int[] ht) {
        int n= ht.length;

        int [] nse= new int[n];
        int [] pse= new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && ht[st.peek()]>= ht[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = n-1;
            }
            else{
                nse[i] = st.peek()-1;
            }
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && ht[st.peek()]>= ht[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = 0;
            }
            else{
                pse[i] = st.peek()+1;
            }
            st.push(i);
        }

        int maxArea= Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int H= ht[i];
            int W= Math.max(1,nse[i]-pse[i]+1);
            int a= H*W;
            maxArea= Math.max(maxArea,a);
        }
        return maxArea;
    }
}