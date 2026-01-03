class Solution {
    public int numOfWays(int n) {
        int mod= 1000000007;
        long typeA=6;
        long typeB=6;

        for(int i=2;i<=n;i++){
            long A= (2*typeA + 2*typeB)%mod;
            long B= (2*typeA + 3*typeB)%mod;

            typeA=A;
            typeB=B;
        }
        return (int)(typeA+typeB)%mod;
    }
}