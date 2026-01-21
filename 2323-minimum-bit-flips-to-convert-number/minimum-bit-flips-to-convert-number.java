class Solution {
    public int minBitFlips(int start, int goal) {
        int flip=0;
        if(start>=goal){
            while(start>0){
                if((start&1)!=0 && (goal&1)==0){
                    flip++;
                }
                else if((start&1)==0 && (goal&1)!=0){
                    flip++;
                }
                start>>=1;
                goal>>=1;
            }
        }
        else{
            while(goal>0){
                if((start&1)!=0 && (goal&1)==0){
                    flip++;
                }
                else if((start&1)==0 && (goal&1)!=0){
                    flip++;
                }
                start>>=1;
                goal>>=1;
            }
        }
        return flip;
    }
}