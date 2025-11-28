class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st= new Stack<>();
        int n=arr.length;
        // HashMap<Integer,Integer> next= new HashMap<>();
        // HashMap<Integer,Integer> prev= new HashMap<>();
        int [] nextMin= new int[arr.length];
        int [] prevMin= new int[arr.length];
       
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                // next.put(arr[st.pop()],i);
                nextMin[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            nextMin[st.pop()]=n;
        }
        
        st= new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                // prev.put(arr[st.pop()],i);
                prevMin[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            prevMin[st.pop()]=-1;
        }
        long ans=0;
        for(int i=0;i<n;i++){
            ans+= (long)arr[i]*(i-prevMin[i])*(nextMin[i]-i);
        }
        return (int)(ans%1000000007);
    }
}