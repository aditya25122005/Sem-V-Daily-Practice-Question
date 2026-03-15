class Solution {
    public long countCommas(long n) {
        ///long start=1000;
        long comma=1;
        long ans=0;
        for(long start=1000;start<=n;start*=1000){
            long end= (start*1000)-1;
            long count = Math.min(n,end)-start+1;
            ans+= (count*comma);
            comma++;
        }
        return ans;
    }
}