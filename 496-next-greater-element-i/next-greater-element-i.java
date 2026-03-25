class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] nge= new int[nums2.length];
        Stack<Integer> st= new Stack<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>=nums2[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=-1;
                map.put(nums2[i],-1);
            }
            else{
                nge[i]= nums2[st.peek()];
                map.put(nums2[i],nge[i]);
            }
            st.push(i);
        }
        int [] ans= new int[nums1.length];
        int idx=0;
        for(int num:nums1){
            ans[idx++] = map.get(num);
        }
        return ans;
    }
}