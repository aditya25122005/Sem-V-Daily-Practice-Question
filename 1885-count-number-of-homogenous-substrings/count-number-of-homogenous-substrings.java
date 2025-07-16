class Solution {
    public int countHomogenous(String s) {
         long mod=1000000007;
        int n=s.length();
        long ans=0;
        long curr=0;
        char ch=s.charAt(0);
        for(int i=0;i<n;i++){
            if(s.charAt(i)==ch){
                curr++;
            }
            else{
                ch=s.charAt(i);
                ans= (ans+  (curr+1)* curr/2 )% mod;
                curr=1;
            }
        }
        ans= (ans+(curr+1)*curr/2)%mod;
        return (int)(ans%mod);
    }
}
