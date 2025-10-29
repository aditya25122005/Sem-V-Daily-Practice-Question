class Solution {
    public int maximalRectangle(char[][] matrix) {
        int [] ht= new int[matrix[0].length];

        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    ht[j]=0;
                }
                else{
                    ht[j]++;
                }
            }
            ans=Math.max(ans,Largest(ht));
        }
        return ans;
    }
    public static int Largest(int[] ht){
        int ans=0;
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<ht.length;i++){
            while(!st.isEmpty() && ht[i]<ht[st.peek()]){
                int h=ht[st.pop()];
                int r=i;
                if(st.isEmpty()){
                    ans=Math.max(ans,h*r);
                }else{
                    int l=st.peek();
                    int width=r-l-1;
                    ans=Math.max(ans,h*width);
                }
            }
            st.push(i);
        }
        int r=ht.length;
        while(!st.isEmpty()){
            int h= ht[st.pop()];
            int width;
            if(st.isEmpty()){
                width=r;
            }else{
                int l= st.peek();
                width=r-l-1;
            }
            ans= Math.max(ans,h*width);
        }
        return ans;

    }
}