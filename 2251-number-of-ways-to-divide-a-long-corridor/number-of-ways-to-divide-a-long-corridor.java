class Solution {
    public int numberOfWays(String corridor) {
        int seat=0;
        int last=0;
        long ways=1;
        int mod=1000000007;
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                seat++;
                if(seat>2 && seat%2==1){// It is starting of a new Segment also it is not a first segment
                    ways=(ways*(i-last))%mod;
                }
                last=i;
            }
        }
        return seat>1 && seat%2!=1 ? (int)ways:0;
    }
}