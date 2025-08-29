public class count_subsequence
{
public static void main(String[] args) {
    String ques="abc";
    String ans="";
    count(ques, ans);
    System.out.println(count);
}
static int count=0;
public static void count(String ques, String ans){
    if(ques.length()==0){
        count++;
        return;
    }
    char ch=ques.charAt(0);
    count(ques.substring(1),ans);
    count(ques.substring(1), ans+ch);

}
}