class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count=0;
        for(int i=0;i<points.length-1;i++){
            int []A=points[i];
            int []B=points[i+1];
            int x1=A[0];
            int y1=A[1];

            int x2=B[0];
            int y2=B[1];
            while(x1!=x2 || y1!=y2){
                if(x2>x1 && y2>y1){
                    x1++;
                    y1++;
                }
                else if(x1>x2 && y1>y2){
                    x1--;
                    y1--;
                }
                else if(x1<x2 && y1>y2){
                    x1++;
                    y1--;
                }
                else if(x1>x2 && y1<y2){
                    x1--;
                    y1++;
                }
                else if(x1<x2){
                    x1++;
                }
                else if(y1<y2){
                    y1++;
                }
                else if(x1>x2){
                    x1--;
                }
                else if(y1>y2){
                    y1--;
                }
                count++;
                
            }
        }
        return count;
    }
}