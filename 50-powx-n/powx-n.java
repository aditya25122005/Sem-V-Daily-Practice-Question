class Solution {
    public double myPow(double x, int n) {
        long N = n;
        boolean nega= false;
        if(n<0){
            N = N*-1;
            nega=true;
        }
        double ans = Solve(x,N);
        if(nega){
            return ((double)1/ans);
        }
        return ans;
        

    }
    public static double Solve(double a, long b){
        double ans = 1;
        while(b!=0){
            if(b%2==1){
                b--;
                ans = (double)ans*a;
            }
            a = (double)a*a;
            b=b/2;
        }
        return ans;
    }
}