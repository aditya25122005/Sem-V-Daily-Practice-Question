class Solution {
    public int minSteps(int n) {
        return Solve(n,1,0,0);
    }
    public static int Solve(int n, int curr, int clipboard, int steps){

        if(curr>n || clipboard>n){
            return Integer.MAX_VALUE;
        }
        if(curr==n){
            return steps;
        }

        int copy=Integer.MAX_VALUE;
        int paste=Integer.MAX_VALUE;
        if(clipboard!=curr){
            copy= Solve(n,curr,curr,steps+1);
        }
        if(clipboard>0){
            paste= Solve(n,curr+clipboard,clipboard,steps+1);
        }
        return Math.min(copy,paste);

    }
}