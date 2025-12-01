class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int alwaysS=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                alwaysS+= customers[i];
            }
        }
        int firstWin=0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i]==1){
                firstWin+= customers[i];
            }
        }
        


        int curr=firstWin;
        int ei=minutes;
        int si=0;
        while(ei<grumpy.length){
            if(grumpy[ei]==1){
                curr+= customers[ei];
            }
            if(grumpy[si]==1){
                curr-= customers[si];
            }
            firstWin=Math.max(firstWin,curr);
            ei++;
            si++;
        }
        return alwaysS+firstWin;

    }
}