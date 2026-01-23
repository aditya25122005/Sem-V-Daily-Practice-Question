class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n= nums.length;
        int K= n-k;

        Stack<Integer> st= new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && K>0 && st.peek() > nums[i]){
                st.pop();
                K--;
            }
            st.push(nums[i]);
        }
        while(K>0){
            st.pop();
            K--;
        }
        List<Integer> ans= new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        Collections.reverse(ans);
        int [] res= new int[k];
        for(int i=0;i<res.length;i++){
            res[i]= ans.get(i);
        }
        return  res;


// return ans;
    }
}