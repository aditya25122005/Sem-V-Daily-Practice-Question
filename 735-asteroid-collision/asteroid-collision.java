class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n= arr.length;
       
        for(int i=0;i<n;i++){
            if(st.isEmpty() || (st.peek()<0 && arr[i]>0) || samesign(arr[i],st.peek())){
                st.push(arr[i]);
            }
            else{

                while(!st.isEmpty() && !samesign(arr[i],st.peek()) && Math.abs(arr[i])> Math.abs(st.peek())){
                    st.pop();// pop all values from top of stack that are smaller than current asteroid 
                }
                if(st.isEmpty() || st.peek()<0){ // if negative on top then we can safely add arr[i]
                    st.push(arr[i]);
                }
                else if(st.peek()==Math.abs(arr[i])){
                    st.pop();
                }
            }
        }


        int [] ans= new int[st.size()];
        int idx=0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }
        reverse(ans);
        return ans;


    }
    public static boolean samesign(int a, int b){
        if(a<0 && b<0) return true;
        if(a>0 && b>0) return true;
        return false;
    }
    public static void reverse(int[] arr){
        int i=0;
        int j= arr.length-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}