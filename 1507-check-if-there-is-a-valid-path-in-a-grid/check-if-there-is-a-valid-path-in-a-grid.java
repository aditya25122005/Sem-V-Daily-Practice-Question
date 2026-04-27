class Solution {
    /*
    1 which means a street connecting the left cell and the right cell.
    2 which means a street connecting the upper cell and the lower cell.
    3 which means a street connecting the left cell and the lower cell.
    4 which means a street connecting the right cell and the lower cell.
    5 which means a street connecting the left cell and the upper cell.
    6 which means a street connecting the right cell and the upper cell.
     */
     int n;
     int m;

    public boolean hasValidPath(int[][] grid) {
        n= grid.length;
        m= grid[0].length;
        boolean [][] vis = new boolean[n][m];
        return Solve(grid,0,0,vis);
    }
    public  boolean Solve(int [][] grid, int cr, int cc, boolean [][] vis){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid[0].length || vis[cr][cc]){
            return false;
        } 
        if(cr==n-1 && cc==m-1){
            return true;
        }
        vis[cr][cc]= true;

        int curr = grid[cr][cc];
        boolean A = false;
        boolean B = false;
        boolean C = false;
        boolean D = false;
        // check for right
        if(cc+1<m){
            if(curr==1 || curr==4 || curr==6){
                if(grid[cr][cc+1]==3 || grid[cr][cc+1]==5 || grid[cr][cc+1]==1){
                    A = Solve(grid,cr,cc+1,vis);
                }
            }
        }
        // check for left
        if(cc-1>=0){
            if(curr==1 || curr==3 || curr==5){
                if(grid[cr][cc-1]==4 || grid[cr][cc-1]==6 || grid[cr][cc-1]==1){
                   B = Solve(grid,cr,cc-1,vis);
                }
            }
        }
        // check for top
        if(cr-1>=0){
            if(curr==2 || curr==5 || curr==6){
                if(grid[cr-1][cc]==2 || grid[cr-1][cc]==3 || grid[cr-1][cc]==4){
                   C = Solve(grid,cr-1,cc,vis);
                }
            }
        }
        // check for  down
        if(cr+1<n){
            if(curr==2 || curr==3 || curr==4){
                if(grid[cr+1][cc]==2 ||grid[cr+1][cc]==5 || grid[cr+1][cc]==6){
                   D = Solve(grid,cr+1,cc,vis);
                }
            }
        }

        vis[cr][cc]=false;
        return A || B || C || D;

    }
    public static int[][] find(int num){
        if(num==1){
            return new int[][]{{0,-1},{0,1}};
        }
        else if(num==2){
            return new int[][]{{-1,0},{1,0}};
        }
        else if(num==3){
            return new int[][]{{0,-1},{1,0}};
        }
        else if(num==4){
            return new int[][]{{0,1},{1,0}};
        }
        else if(num==5){
            return new int[][]{{-1,0},{0,-1}};
        }
        else{
            return new int[][]{{-1,0},{0,1}};
        }
    }
}