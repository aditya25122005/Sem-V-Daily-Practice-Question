class Solution {
    public int totalMoney(int n) {
        int start=1;
        int curr=1;
        int bank=0;
        while(n!=0){
            bank+=curr;
            curr++;
            if(curr==start+7){
                start++;
                curr=start;
            }
            n--;
        }
        return bank;
    }
}