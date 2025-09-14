class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int testPerPig=minutesToTest/minutesToDie;
        int Pigs=0;
        int state=1; // Die Or Survive
        while(state<buckets){
            state*= (testPerPig+1);
            Pigs++;
        }
        return Pigs;
    }
}