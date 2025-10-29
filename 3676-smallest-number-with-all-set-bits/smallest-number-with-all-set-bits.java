class Solution {
    public int smallestNumber(int n) {
        int ans=0;
        int a=0;
        String s= Integer.toBinaryString(n);
        for(int i=0;i<s.length();i++){
            ans+= Math.pow(2,a);
            a++;
        }
        return ans;
    }
}