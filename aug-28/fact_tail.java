public class fact_tail {
    public static void main(String[] args) {
        int n=5;
        System.out.println(Fact(n,1));
    }
    public static int Fact(int n,int ans){
        if(n==0){
            return ans;
        }
        return Fact(n-1,ans*n);
    }
}
