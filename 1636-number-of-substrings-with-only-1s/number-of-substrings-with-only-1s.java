class Solution {
    public int numSub(String s) {
        long curr=0;
        long ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                curr++;
            }
            else{
                ans+= (curr*(curr+1)/2)%1000000007;
                curr=0;
            }
        }
        ans+= (curr*(curr+1)/2)%1000000007;
        return (int)(ans%1000000007);
    }
}