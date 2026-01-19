class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] ans= new int[nums1.length];
        HashMap<Integer,Integer> map= new HashMap<>(); // for storing next greater
        Stack<Integer> st= new Stack<>();
        int n=nums2.length;
        for(int i=n-1;i>=0;i--){

            while(!st.isEmpty() && nums2[i] >=nums2[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(nums2[i],-1);
            }
            else{
                map.put(nums2[i],nums2[st.peek()]);
            }
            st.push(i);
        }
        for(int i=0;i<nums1.length;i++){
            int val= nums1[i];
            ans[i] = map.get(val);
        }
        return ans;

    }
}