public class fibonacci {
    public static void main(String[] args) {
        int n=6;
        // 0 1 1 2 3 5 8
        System.out.println(Fibo(n));
    }
    public static int Fibo(int n){
        if(n==0 || n==1){
            return n;
        }
        return Fibo(n-1)+Fibo(n-2);
    }

}
