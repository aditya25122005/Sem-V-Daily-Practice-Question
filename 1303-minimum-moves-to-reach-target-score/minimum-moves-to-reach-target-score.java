class Solution {
    public int minMoves(int target, int maxDoubles) {
        int opr=0;
        while(target!=1){
            if(target%2==0 && maxDoubles>0){
                target/=2;
                maxDoubles--;
            }
            else if(maxDoubles==0){
                opr+= target-1;
                break;
            }
            else{
                target--;
            }
            opr++;
        }
        return opr;
    }
}