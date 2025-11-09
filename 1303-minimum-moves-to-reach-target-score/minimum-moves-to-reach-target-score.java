class Solution {
    public int minMoves(int num, int maxD) {
        int target=1;
        int opr=0;
        if(maxD==0) return num-1;
        while(num!=target){
            
            while(num/2>=target  && maxD>0){
            while(num%2==1){
                num--;
                opr++;
            }
                num/=2;
                maxD--;
                opr++;
            }
            while(num>target){
                num--;
                opr++;
            }
        }
        return opr;
        
    }
}