class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n= asteroids.length;
        Stack<Integer> st= new Stack<>();


        for(int i=0;i<n;i++){
            if(st.isEmpty() || st.peek()<0 && asteroids[i]>0 || sameSign(st.peek(),asteroids[i])){
                st.push(asteroids[i]); // if curr aste. has same sign as of prev. one then push on stack,
            }
            else{
                while(!st.isEmpty() && asteroids[i]<0 && st.peek()>0 && st.peek()<-asteroids[i]){  
                    st.pop();
                }
                if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                }
                else if(st.peek()==Math.abs(asteroids[i])){
                    st.pop();
                }
            }
                
            
             
        }
        int idx=0;
        int [] ans= new int[st.size()];
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }
        reverse(ans);
        return ans;
    }
    public static boolean sameSign(int a, int b){
        if(a>0 && b>0){
            return true;
        }
        if(a<0 && b<0) return true;
        return false;
    }
    public static void reverse(int [] arr){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}