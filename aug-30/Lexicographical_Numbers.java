public class Lexicographical_Numbers {
    public static void main(String[] args) {
        int n=1000;
        int curr=0;
        Lexico_Numbers(n, curr);
    }
    public static void Lexico_Numbers(int n, int curr){
        if(curr>n){
            return;
        }
        System.out.println(curr);
        int i=0;
        if(curr==0){
            i=1;
        }
        for(;i<=9;i++){
            Lexico_Numbers(n, curr*10 +i);
        }
    }
}
