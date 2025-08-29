public class permutation {
    public static void main(String[] args) {
        String ques="abc";
        /* abc, acb, bac, bca , cab, cba */
        String ans="";
        permut(ques, ans);
    }
    public static void permut(String ques, String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        // loop for starting ans string with every character 
        for(int i=0;i<ques.length();i++){
            char ch= ques.charAt(i);
            // make new ques by combining the left and right part to the character
            permut(ques.substring(0,i)+ ques.substring(i+1),ans+ch);
        }
    }
}
