class Solution {
    public int numberOfWays(String corridor) {

        long mod=1000000007;
        List<Integer> ll= new ArrayList<>();
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                ll.add(i);
            }
        }
        if(ll.size()%2!=0 || ll.size()==0){
            return 0;
        }
        long ways=1;
        int curr=0;
        for(int i=1;i<ll.size()-1;i+=2){
            int plant=0;
            plant+= (ll.get(i+1)-ll.get(i)-1);
             ways=(ways*(plant+1))%mod;
        }
        return (int)(ways%mod);
        // int n=corridor.length();
        // int ways=1;
        // int mode=0;// start
        // int lastEnd=0;
        // for(int i=0;i<corridor.length();i++){
        //     if(i!=n-1 && corridor.charAt(i)=='S' && mode==0){ // pehli seat
        //         //
        //         int plant=0;
        //         if(lastEnd!=0){
        //         for(int p=lastEnd+1;p<i;p++){
        //             if(corridor.charAt(p)=='P')plant++;
        //         }
        //         }
        //         ways*= (plant+1);
        //         mode=1;// find last seat
        //     }
        //     if(corridor.charAt(i)=='S' && mode==1){// Aakhri seat
        //         mode=0;
        //         lastEnd=i;
        //     }
        // }
        // return ways;
    }
}