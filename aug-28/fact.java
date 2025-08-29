public class fact{
    public static void main(String[] args) {
        int n=7;
        System.out.println(Fact(n));

    }
    public static int Fact(int n){
        if(n==0){
            return 1;
        }
        return n* Fact(n-1);
    }
}