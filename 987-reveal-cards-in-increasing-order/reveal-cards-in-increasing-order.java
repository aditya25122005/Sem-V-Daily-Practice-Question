class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n= deck.length;

        int [] ans= new int[deck.length];
        int deckidx=0;
        int ansidx=0;
        boolean skip= false;
        //2 3 5 7 11 13 17
        // 2  11  3  17  5  13  7

        Arrays.sort(deck);
        while(deckidx<n){
            if(ans[ansidx]==0){
                if(!skip){
                    ans[ansidx]= deck[deckidx];
                    deckidx++;
               
                }
                skip= !skip;
                
            }
           
           ansidx= (ansidx+1)%n;
        }
        return ans;


    }
}