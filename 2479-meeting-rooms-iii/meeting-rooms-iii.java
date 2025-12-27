class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        long [] endR= new long[n];
        int [] ans= new int[n];
        for(int []M:meetings){
            int start=M[0];
            int end=M[1];
            int duration=end-start;
            int room=-1;
            for(int i=0;i<endR.length;i++){
                if(endR[i]<=start){
                    room=i;
                    ans[i]++;
                    endR[i]=end;
                    break;
                }
            }
            if(room==-1){
                // earliest free room
                long min_end_time=Long.MAX_VALUE;
                int idx=-1;
                for(int i=0;i<endR.length;i++){
                    if(endR[i]<min_end_time){
                        min_end_time=endR[i];
                        idx=i;
                    }
                }
                ans[idx]++;
                endR[idx]+= duration;

            }
        }
        int res=-1;
        int max=0;
        for(int i=0;i<ans.length;i++){
            if(ans[i]>max){
                max=ans[i];
                res=i;
            }
        }
        return res;

    }
}