class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n&1;

        while(n!=0){
            int digit = (n&1);
            if(digit!=prev){
                return false;
            }
            if(prev==1){
                prev=0;
            }
            else{
                prev=1;
            }
            n = (n>>1);
        }
        return true;
    }
}