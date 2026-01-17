class Solution {
    public int computeArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        //24+27-6=45
        //A+B-common

        int l1= Math.abs(x2-x1);
        int h1=Math.abs(y2-y1);
        int a1= l1*h1;

        int l2= Math.abs(x4-x3);
        int h2=Math.abs(y4-y3);
        int a2= l2*h2;

        int commonWt= Math.min(x2,x4)-Math.max(x1,x3);
        int commonHt= Math.min(y2,y4)-Math.max(y1,y3);

        if(commonWt<0 || commonHt<0) 
        return a1+a2;

        
        int common= Math.abs(commonWt * commonHt);
        return  a1+a2-common;


        
    }
}