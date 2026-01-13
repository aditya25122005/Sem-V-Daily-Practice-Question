class Solution {
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        boolean [] isPrime= new boolean[n];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;

        for(int i=2;i*i<n;i++){ // 2,4,6,8,10,12,14,16,18,20
            for(int j=i*i;j<n;j+=i){
                if(isPrime[j]){
                    isPrime[j]=false;
                }
            }
        }
        int count=0;
        for(int i=0;i<isPrime.length;i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }
}