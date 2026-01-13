class Solution {
    public int largestPrime(int n) {
        List<Integer> Primes= new ArrayList<>();
        boolean [] isPrime= new boolean[n+1];
        Arrays.fill(isPrime,true);

        isPrime[0]=false;
        isPrime[1]=false;

        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(isPrime[i]){
                Primes.add(i);
            }
        }
        int sum=0;
        int ans=0;
        for(int num:Primes){
            sum+=num;
            if(sum>n){
                break;
            }
            if(isPrime[sum]){
                ans=sum;
            }
            
        }
        return ans;

    }
}