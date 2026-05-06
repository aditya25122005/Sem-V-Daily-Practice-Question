class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int [] ans = new int[3];
        int i=1;
        while(memory1>=i || memory2>=i){
            if(memory1>memory2){
                memory1-=i;
            }
            else if(memory2>memory1){
                memory2-=i;
            }
            else{
                memory1-=i;
            }
            i++;
        }
        return new int[]{i,memory1,memory2};
        // 8,10
        // 8,8
        // 5,8
        // 5,4
        // 0,4
        // [6,0,4]
    }
}