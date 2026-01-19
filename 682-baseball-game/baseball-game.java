class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st= new Stack<>();
        for(String str:operations){
            if(str.equals("+")){
                int a= st.pop();
                int b= st.pop();
                int c= a+b;
                st.push(b);
                st.push(a);
                st.push(c);
            }
            else if(str.equals("D")){
                int prev= st.peek();
                st.push(2*prev);
            }
            else if(str.equals("C")){
                st.pop();
            }
            else{
                st.push(Integer.parseInt(str));
            }

        }
        int sum=0;
        while(!st.isEmpty()){
            sum+= st.pop();
        }
        return sum;
    }
}