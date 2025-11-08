class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int [][] dp= new int[dungeon.length][dungeon[0].length];
        for(int []a:dp){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        return Solve(0,0,dungeon,dp);
    }
    public static int Solve(int cr, int cc, int [][]grid, int [][] dp){
        if(cr>=grid.length || cc>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[cr][cc]!=Integer.MAX_VALUE){
            return dp[cr][cc];
        }

        int a=Solve(cr+1,cc,grid,dp);
        int b=Solve(cr,cc+1,grid,dp);
        int health=Math.min(a,b);
        if(health==Integer.MAX_VALUE){
            health=1;
        }
        return dp[cr][cc]= Math.max(1,health-grid[cr][cc]);

    }
}