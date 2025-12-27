class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
     int [] ans= new int[n];
     long [][] rooms= new long[n][2];
     for(int[] M:meetings){
        int start= M[0];
        int end=M[1];
        int duration= end-start;
        int room=-1;
        for(int i=0;i<rooms.length;i++){
            if(rooms[i][1]<=start){
                ans[i]++;
                rooms[i][1]=end;
                room=i;
                break;
            }
        }
        
        if(room==-1){
            
            long earliest=Long.MAX_VALUE;
            int idx=-1;
            for(int i=0;i<rooms.length;i++){
                if(rooms[i][1]<earliest){
                    earliest=rooms[i][1];
                    idx=i;
                }
            }
            ans[idx]++;
            rooms[idx][1]+=duration;
        }


     }   
     int max=0;
     int idx=0;
     for(int i=0;i<ans.length;i++){
        if(ans[i]>max){
            max=ans[i];
            idx=i;
        }
     }
     return idx;
    }
}