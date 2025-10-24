class Solution {
    public int nextBeautifulNumber(int n) {
        int num=n+1;
        while(!check(num)){
            num++;
            check(num);
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
        if(freq[0]>0) return false;
        for(int i=0;i<=9;i++){
            if(freq[i]!=0 && freq[i]!=i){
                return false;
            }
        }
        return true;
    }
}