class Solution {
    public int maxBottlesDrunk(int Bottles, int Exchange) {
        int drink=Bottles;
        int empty=Bottles; //10
        int full=0;
        while(empty>=Exchange){
            full++;
            empty-=Exchange;
            Exchange++;
        }
        empty+=full;
        if(empty>=Exchange) drink++;
        return drink+full;
    }
}