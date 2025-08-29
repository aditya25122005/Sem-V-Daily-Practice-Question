import java.util.ArrayList;
import java.util.List;

public class key_pad {
    public static void main(String[] args) {
        String digits="23";
        System.out.println(letterCombinations(digits));
    }
    public static  List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        List<String> ll= new ArrayList<>();
        solve(ll,digits,"");
        return ll;
    }
    static  String[] keys={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void solve(List<String>ll, String ques, String ans){
        if(ques.length()==0){
            ll.add(ans);
            return;
        }
        char ch= ques.charAt(0);
        int idx=ch-'0';
        String s=keys[idx];
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            solve(ll,ques.substring(1),ans+c);
        }
    }
}
