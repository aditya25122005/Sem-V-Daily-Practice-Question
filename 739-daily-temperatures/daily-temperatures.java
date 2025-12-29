class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int [] res= new int[temp.length];
        int n=res.length;
        res[n-1]=0;
        int min=temp[n-1];
        // next greater element
        Stack<Integer> st= new Stack<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<temp.length;i++){
            while(!st.isEmpty() && temp[i]>temp[st.peek()]){
                map.put(st.pop(),i);
            }
            st.push(i);
        }
        for(int i=0;i<res.length;i++){
            if(map.containsKey(i)){
                res[i]=map.get(i)-i;
            }
        }
        return res;

    }
}