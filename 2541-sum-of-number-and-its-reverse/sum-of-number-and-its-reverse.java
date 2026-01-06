class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=num/2;i<=num;i++){
            int rev= reverse(i);
            if(rev+i==num) return true;
        }
        return false;

    }
    public static int reverse(int num){
        int n=0;
        while(num!=0){
            int r=num%10;
            n=n*10+ r;
            num/=10;
        }
        return n;
    }
}