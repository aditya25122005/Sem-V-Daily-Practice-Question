class Solution {
    public String reverseWords(String s) {
        String [] arr= s.split(" ");
        StringBuilder sb= new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            String st = arr[i];
            int j=0;
            int k= st.length()-1;
            while(j<st.length() && st.charAt(j)==' '){
                    j++;
            }
            while(k>=0 && st.charAt(k)==' '){      
                    k--;
            }
            if(j<=k){
            sb.append(st.substring(j,k+1));
            sb.append(" ");
            }
           
        }
        return sb.toString().trim();
    }
}