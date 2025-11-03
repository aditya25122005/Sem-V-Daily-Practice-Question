class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char [][] grid= new char[m][n];
        int cnt=0;
        for(int [] A:guards){
            grid[A[0]][A[1]]='G';
        }
        for(int [] A:walls){
            grid[A[0]][A[1]]='W';
        }
        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[0].length;j++){
        //         if(grid[i][j]=='G'){
        //         Solve(grid,i,j);
        //         }
        //     }
        // }

        for(int[] G :guards){
            Solve(grid,G[0]-1,G[1],-1,0);
            Solve(grid,G[0]+1,G[1],1,0);
            Solve(grid,G[0],G[1]-1,0,-1);
            Solve(grid,G[0],G[1]+1,0,1);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='O'){
                    cnt++; // cnt is occupied cells by guards
                }
            }
        }
        return m*n - cnt -guards.length - walls.length; // Unoccupied cells
    }
    public static void Solve(char[][] grid, int cr, int cc, int nr, int nc){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid[0].length || grid[cr][cc]=='W' || grid[cr][cc]=='G'){
            return;
        }

        grid[cr][cc]='O';
        Solve(grid,cr+nr,cc+nc,nr,nc);

    }

}