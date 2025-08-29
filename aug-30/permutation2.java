public class permutation2 {
    public static void main(String[] args) {
        String s="abca";
        String ans="";
        permut(s, ans);
    }
    public static void permut(String s, String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!isPresent(s,i+1,ch)){
                permut(s.substring(0,i)+s.substring(i+1),ans+ch);
            }
        }
    }
    public static boolean isPresent(String s, int i ,char ch){
        for(int j=i;j<s.length();j++){
            if(s.charAt(j)==ch){
                return true;
            }
        }
        return false;
    }
}
