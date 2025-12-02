class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty() || (st.peek()<0 && arr[i]>0) || samesign(arr[i],st.peek()) ){
                st.push(arr[i]);
            }
            else{
                while(!st.isEmpty() && arr[i]<0 && st.peek()>0 && st.peek()<-arr[i]){
                    st.pop();
                }

                if(st.isEmpty() || st.peek()<0 ){
                    st.push(arr[i]);
                }
                else if(st.peek()== Math.abs(arr[i])){
                    st.pop();
                }
            }
        }
        int [] ans= new int[st.size()];
        int i=ans.length-1;
        while(i>=0){
            ans[i]=st.pop();
            i--;
        }
        return ans;

    }
    public static boolean samesign(int a, int b){
        if(a<0 && b<0){
            return true;
        }
        if(a>0 && b>0){
            return true;
        }
        return false;
    }
}