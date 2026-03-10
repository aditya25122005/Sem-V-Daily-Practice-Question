class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        char [] inst= s.toCharArray();
        int [] ans= new int [inst.length];
        for(int start=0;start<inst.length;start++){
            ans[start]= Solve(n, startPos[0], startPos[1], start, inst,0);
        }
        return ans;
    }
    public static int Solve(int n,int cr, int cc, int idx, char [] inst,int curr){
        if(idx>=inst.length) return curr;
        

        char ch= inst[idx];
        int nr= cr;
        int nc= cc;
        if(ch=='U'){
            nr--;
        }
        if(ch=='D'){
            nr++;
        }
        if(ch=='L'){
            nc--;
        }
        if(ch=='R'){
            nc++;
        }
        if(nc<0 || nr<0 || nr>=n || nc>=n){
            return curr;
        }
        return Solve(n,nr,nc,idx+1,inst,curr+1);

    }
}