class Solution {
    public boolean stoneGame(int[] piles) {
        int [][] DP = new int[piles.length][piles.length];
        for(int [] d: DP){
            Arrays.fill(d,-1);
        }
        return Solve(piles,0,piles.length-1,DP)>0? true: false;
    }
    public static int Solve(int [] piles , int i, int j, int [][] DP){
        if(i>=j){
            return piles[i];
        }
        if(DP[i][j] != -1) return DP[i][j];
        int A=0;
        int B=0;
        int C=0;
        int D=0;
        // Alice
        A = piles[i] - Solve(piles, i+1,j,DP);
        B = piles[j] - Solve(piles,i, j-1,DP);
        return DP[i][j] = Math.max(A,B);
    }
}