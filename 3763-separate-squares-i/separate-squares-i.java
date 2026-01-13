class Solution {
    public double separateSquares(int[][] squares) {
        double lo=Double.MAX_VALUE;
        double hi=Double.MIN_VALUE;
        double total=0;

        for(int[] A:squares){
            int x=A[0];
            int y=A[1];
            int len=A[2];
            lo=Math.min(lo,y);
            hi=Math.max(hi,y+len);
            total+= (double)len*len;
        }
        double target= total/2;
        double ans=0;
        while(hi-lo>0.000001){
            double mid= lo+(hi-lo)/2;
            double areaBelow= Area(mid, squares);
            if(areaBelow>=target){
                ans=mid;
                hi=mid;
            }
            else{
                lo=mid;
            }

        }
        return ans;
    }
    public static double Area(double mid, int [][] squares){
        double Area=0;
        for(int [] A:squares){
            int x=A[0];
            int y=A[1];
            int len=A[2];

            if(y+len<=mid){
                Area+= (double)len*len;
            }
            else if(mid>y){    //x * y 
                Area+= (double)len* (mid-y);
            }
        }
        return Area;
    }
}