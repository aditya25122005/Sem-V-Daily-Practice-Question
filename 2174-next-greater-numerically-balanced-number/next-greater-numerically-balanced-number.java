class Solution {
    public int nextBeautifulNumber(int n) {
        int num=n+1;
        while(!check(num)){
            num++;
        }
        return num;

    }
    public static boolean check(int n){
        int [] freq= new int[10];
        int num=n;
        while(num!=0){
            freq[num%10]++;
            num/=10;
        }
        while(n!=0){
            if(freq[n%10]!= n%10){
                return false;
            }
            n/=10;
        }
        return true;
    }
}