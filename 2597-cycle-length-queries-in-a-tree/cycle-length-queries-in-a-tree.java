class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int [] ans= new int[queries.length];
        int idx=0;
        for(int [] Q: queries){
            int n1= Q[0];
            int n2= Q[1];
            ans[idx++] = Solve(n1,n2);
        }
        return ans;
    }
    public static int Solve(int n1, int n2){
        int c=0;
        while(n1!=n2){
            if(n1>n2){
                n1= n1/2;
            }
            else{
                n2= n2/2;
            }
            c++;
        }
        return c+1;
    }
}