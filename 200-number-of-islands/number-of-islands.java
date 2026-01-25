class Solution {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int comp=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    comp++;
                    DFS(grid,i,j);
                }
            }
        }
        return comp;
    }
    public static void DFS(char [][] grid, int cr, int cc){
        if(cr<0 || cc<0 || cr>=grid.length || cc>= grid[0].length || grid[cr][cc]=='0'){
            return;
        }

        grid[cr][cc]='0';
        
        DFS(grid,cr+1,cc);
        DFS(grid,cr-1,cc);
        DFS(grid,cr,cc-1);
        DFS(grid,cr,cc+1);
    }
}