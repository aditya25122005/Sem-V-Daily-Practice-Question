class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n= nums.length;
        Stack<Integer> st= new Stack<>();
        int [] nse= new int[n];
        int [] pse= new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>= nums[i]) st.pop();
            if(st.isEmpty()){
                nse[i]=n;
            }
            else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]) st.pop();
            if(st.isEmpty()){
                pse[i]= -1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int win= nse[i]-pse[i]-1;
            if(nums[i]*win>threshold){
                return win;
            }
        }
        return -1;
    }
}