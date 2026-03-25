class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N= nums.length;
        int [] arr= new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            arr[i]= nums[i];
            arr[i+N] = nums[i];
        }

        Stack<Integer> st= new Stack<>();
        int [] ans= new int[N];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                if(ans[i%N]==0){
                 ans[i%N]=-1;
                }
            }
            else{
                ans[i%N]=arr[st.peek()];
            }
            st.push(i);
        }
        return ans;
    }
}