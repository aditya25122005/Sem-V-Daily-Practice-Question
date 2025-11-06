class Solution {
    public int cherryPickup(int[][] grid) {
       int [][][] dp= new int[grid.length][grid[0].length][grid[0].length];
       for(int i=0;i<dp.length;i++){
        for(int [] A:dp[i]){
            Arrays.fill(A,-1);
        }
       } 
       return Solve(grid,0,0,0,grid[0].length-1,dp);
    }
    public static int Solve(int[][] grid, int cr1, int cc1, int cr2, int cc2, int[][][] dp){
        if(cr1<0 || cc1<0 || cr1>=grid.length || cc1>=grid[0].length ||
        cr2<0 || cc2<0 || cr2>=grid.length || cc2>=grid[0].length){
            return 0;
        }
        if(dp[cr1][cc1][cc2]!=-1){
            return dp[cr1][cc1][cc2];
        }
        int sum=0;

        if(cr1==grid.length-1 && cr2==grid.length-1){
            if(cr1==cr2 && cc1==cc2){
                return grid[cr1][cc1];
            }else{
                return grid[cr1][cc1]+ grid[cr2][cc2];
            }
        }
        
        int a= grid[cr1][cc1];
        int b= grid[cr2][cc2];
        if(cr1==cr2 && cc1== cc2){
            sum+= a;
        }
        else{
            sum+= a+b;
        }

        // sum+= Solve(grid,cr1+1, cc1-1, cr2+1,cr2-1);
        // sum+= Solve(grid,cr1+1, cc1-1, cr2+1,cr2);
        // sum+= Solve(grid,cr1+1, cc1-1, cr2+1,cr2+1);

        // sum+= Solve(grid,cr1+1, cc1, cr2+1,cr2-1);
        // sum+= Solve(grid,cr1+1, cc1, cr2+1,cr2);
        // sum+= Solve(grid,cr1+1, cc1, cr2+1,cr2+1);

        // sum+= Solve(grid,cr1+1, cc1+1, cr2+1,cr2-1);
        // sum+= Solve(grid,cr1+1, cc1+1, cr2+1,cr2);
        // sum+= Solve(grid,cr1+1, cc1+1, cr2+1,cr2+1);

        int max=0;
        for(int dc1=-1;dc1<=1;dc1++){
            for(int dc2=-1;dc2<=1;dc2++){
                max=Math.max(max,Solve(grid,cr1+1,cc1+dc1,cr2+1,cc2+dc2,dp));
            }
        } 
        return dp[cr1][cc1][cc2] = max+sum;
    }
}