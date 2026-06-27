class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int [] pse = new int[n];
        int [] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int L = pse[i];
            int R = nse[i];
            int W = R-L-1;
            int H = heights[i];
            ans = Math.max(ans,W*H);
        }
        return ans;
    }
}