class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int orig=grid[row][col];
        int n=grid.length;
        int m=grid[0].length;
        int[][] G= new int[n][m];
        for(int []A:G) Arrays.fill(A,-1);
        visited= new boolean[n][m];
        Solve(grid,row,col,color,orig,G);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(G[i][j]==-1){
                    G[i][j]=grid[i][j];
                }
            }
        }

        return G;
    }
    static boolean[][] visited;
    public static void Solve(int[][] arr, int cr, int cc, int color, int orig, int[][]G){
        if(cr<0 || cr>=arr.length || cc<0 || cc>=arr[0].length || arr[cr][cc]!=orig ||
        visited[cr][cc]){
            return;
        }
        visited[cr][cc]=true;
        if(cr==0 || arr[cr-1][cc]!=orig){
            G[cr][cc]=color;
        }
        if(cr==arr.length-1 || arr[cr+1][cc]!=orig){
            G[cr][cc]=color;
        }
        if(cc==0 || arr[cr][cc-1]!=orig){
            G[cr][cc]=color;
        }
        if(cc==arr[0].length-1 || arr[cr][cc+1]!=orig){
            G[cr][cc]=color;
        }



        Solve(arr,cr+1,cc,color,orig,G);
        Solve(arr,cr-1,cc,color,orig,G);
        Solve(arr,cr,cc-1,color,orig,G);
        Solve(arr,cr,cc+1,color,orig,G);
    }
}