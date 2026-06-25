class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] arr = new int[2*n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
            arr[i+n] = nums[i];
        }
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }
        int [] nge = new int[2*n];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nge[i] = st.peek();
            }
            else{
                nge[i] = -1;
            }
            st.push(arr[i]);
        }
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = nge[i];
        }
        return res;
    }
}