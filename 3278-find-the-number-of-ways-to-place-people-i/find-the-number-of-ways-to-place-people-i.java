class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,(a,b)->b[1]-a[1]);
        int c=0;
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i==j) continue;

                int x1=points[i][0];
                int y1= points[i][1];

                int x2= points[j][0];
                int y2= points[j][1];
                boolean isSafe=true;
                if(x1<=x2 && y1>=y2){
                    for(int [] p:points){
                        if((p[0]==x1 && p[1]==y1)  || (p[0]==x2 && p[1]==y2)) continue;
                        if((p[0]>=x1 && p[0] <=x2)  && (p[1]>=y2 && p[1]<=y1)){
                            isSafe=false;
                            break;
                         }
                    }
                    if(isSafe) c++;
                }


            }
        }
        return c;
    }
}