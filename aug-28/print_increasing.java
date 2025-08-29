public class print_increasing {
    public static void main(String[] args) {
        int n=5;
        Print(n);

    }
    public static void Print(int n){
        if(n==0){
            return;
        }
        Print(n-1);
        System.out.println(n);
    }
}
