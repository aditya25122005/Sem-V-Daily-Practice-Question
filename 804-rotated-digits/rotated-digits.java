class Solution {
    public int rotatedDigits(int n) {
        int c = 0;
        for(int i=1;i<=n;i++){
            if(!inValid(i) && containsValid(i)){
                c++;
            }
        }
        return c;
    }
    public static boolean inValid(int n){
        int num=n;
        while(num!=0){
            int rem = num%10;
            if(rem==3 || rem==4 || rem==7){
                return true;
            }
            num/=10;
        }
        return false;
    }
    public static boolean containsValid(int n){
        int num=n;
        while(num!=0){
            int rem = num%10;
            if(rem==6 || rem==9 || rem==2 || rem==5){
                return true;
            }
            num/=10;
        }
        return false;
    }
}