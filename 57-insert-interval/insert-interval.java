class Solution {
    public int[][] insert(int[][] arr, int[] nI) {
        List<int[]> ll= new ArrayList<>();
        int i=0;
        
        while(i<arr.length && arr[i][0]<= nI[0]){
            ll.add(arr[i]);
            i++;
        }
        ll.add(nI);
        while(i<arr.length){
            ll.add(arr[i]);
            i++;
        }
        
        i=0;

        Stack<int[]> st= new Stack<>();
        st.push(ll.get(0));
        while(i+1<ll.size()){
            int [] prev= st.peek();
            int [] next= ll.get(i+1);

            if(next[0]>= prev[0] && next[0]<= prev[1]){
                st.peek()[1]= Math.max(prev[1],next[1]);
            }
            else{
                st.push(next);
            }
            i++;
        }
        List<int[]> a= new ArrayList<>();
        int [][] ans= new int[st.size()][2];
        int idx=0;
        while(!st.isEmpty()){
            a.add(st.pop());
        }
        for(int j=a.size()-1;j>=0;j--){
            ans[idx][0]=a.get(j)[0];
            ans[idx][1]=a.get(j)[1];
            idx++;
        }
        return ans;

        
    }
}