class Solution {
    public boolean checkStraightLine(int[][] c) {
        int x1=c[0][0];
        int y1=c[0][1];

        int x2=c[1][0];
        int y2=c[1][1];

        
        for(int i=2;i<c.length;i++){
            int x3=c[i][0];
            int y3=c[i][1];
            if( (y2-y1) * (x3-x2) != (y3-y2)*(x2-x1)){
                return false;
            }
            

        }
        return true;
    }
}