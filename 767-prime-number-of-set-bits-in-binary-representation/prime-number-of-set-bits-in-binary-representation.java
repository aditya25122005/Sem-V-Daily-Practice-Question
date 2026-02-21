class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
       
       for(int num=left;num<=right;num++){
           int set= countSet(num);
           if(checkPrime(set)){
               ans++;
           }
       }
       return ans;
    }
    public static boolean checkPrime(int num){
        if(num<=1) return false;
        int c=0;
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                c++;
            }
        }
        return c==0;
    }
    public static int countSet(int num){
        int set=0;
        while(num!=0){
            set++;
            num=num&(num-1);
        }
        return set;
    }
}