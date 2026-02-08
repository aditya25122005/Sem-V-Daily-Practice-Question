class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> ll= new ArrayList<>();
        // for(int num:nums){
        //     ll.add((long)num);
        // }
        Stack<Long> st= new Stack<>();
        for(int i=0;i<nums.length;i++){
            long curr= nums[i];
            while(!st.isEmpty() && st.peek()== curr){
                curr+= st.pop();
            }
            st.push(curr);
        }
        while(!st.isEmpty()){
            ll.add(st.pop());
        }
        Collections.reverse(ll);
        return ll;

    }
}