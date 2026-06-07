class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int lo = 0;
        int hi = Math.max(n+k,n*k);
        int sum = 0;
        for(int i=lo;i<=hi;i++){
            if(Math.abs(n-i)<=k && (n&i)==0){
                sum+=i;
            }
        }
        return sum;
    }
}