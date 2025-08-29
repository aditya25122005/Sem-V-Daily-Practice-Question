import java.util.*;
public class Generate_Parenthesis {
    public static void main(String[] args) {
        int n=3;
        List<String> ll= new ArrayList<>();
        Generate(n,0,0,"",ll);
        System.out.println(ll);
    }
    public static void Generate(int n, int open, int close,String ans, List<String> ll){
        if(open==n && close==n){
            ll.add(ans);
            return;
        }
        if(open>n || close>open){
            return;
        }
        Generate(n, open+1, close, ans+"(", ll);
        Generate(n, open, close+1, ans+")", ll);
    }
}
