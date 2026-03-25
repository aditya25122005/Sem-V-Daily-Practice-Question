class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n= asteroids.length;
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty() || sameSign(st.peek(), asteroids[i]) || 
             st.peek()<0 && asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{

                while(!st.isEmpty() && !sameSign(asteroids[i], st.peek()) && Math.abs(asteroids[i]) > Math.abs(st.peek())){
                    st.pop();
                }
                if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                }
                else if(Math.abs(st.peek()) == Math.abs(asteroids[i])){
                    st.pop();
                }
            }
            

        }
      
        int [] ans= new int[st.size()];
        int idx=ans.length-1;
        while(!st.isEmpty()){
            ans[idx--]=st.pop();
        }
        return ans;

    }
    public static boolean sameSign(int a, int b){
        if(a<0 && b<0) return true;
        if(a>0 && b>0) return true;
        return false;
    }
}