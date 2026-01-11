class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n= matrix.length;
        int m=matrix[0].length;
        int ans=0;
        int [] ht= new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0'){
                    ht[j]=0;
                }
                else{
                    ht[j]++;
                }

            }
            ans=Math.max(ans,largestRectangle(ht));
        }
        return ans;


    }
    public static int largestRectangle(int[] ht){
        Stack<Integer> st= new Stack<>();
        int [] PSE= new int[ht.length];
        for(int i=0;i<ht.length;i++){
            while(!st.isEmpty() && ht[st.peek()]>=ht[i]){
                st.pop();
            }
            if(st.isEmpty()){
                PSE[i]=0;
            }
            else{
                PSE[i]=st.peek()+1;
            }
            st.push(i);
        }
        st.clear();
        int [] NSE= new int[ht.length];
        for(int i=ht.length-1;i>=0;i--){
            while(!st.isEmpty() && ht[st.peek()]>=ht[i]){
                st.pop();
                
            }
            if(st.isEmpty()){
                NSE[i]=ht.length-1;
            }
            else{
                NSE[i]=st.peek()-1;
            }
            st.push(i);
        }
        int max=0;
        for(int i=0;i<ht.length;i++){
            int curr= ht[i]*(NSE[i]-PSE[i]+1);
            max=Math.max(max,curr);
        }
        return max;
    }
}