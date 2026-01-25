class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans= new ArrayList<>();
        int n=heights.length;
        int m= heights[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==m-1){
                    ans.add(Arrays.asList(i,j));
                }
                else if(i==n-1 && j==0){
                    ans.add(Arrays.asList(i,j));
                }
                else{
                    boolean [][] visited= new boolean[n][m];
                    boolean P= reachPacific(heights,i,j,visited);
                    
                    visited= new boolean[n][m];
                    boolean A= reachAtlantic(heights,i,j,visited);
                    if(P && A){
                        ans.add(Arrays.asList(i,j));
                    }
                }
            }
        }
        return ans;
    }
    public static boolean reachPacific(int[][] grid, int cr, int cc, boolean [][] visited){
        

        if(cr==0 || cc==0){
            return true;
        }
        if(cc>=grid[0].length || cr>= grid.length || cr<0 || cc<0 || visited[cr][cc]){
            return false;
        }
        visited[cr][cc]= true;
        boolean first=false;
        boolean second=false;
        boolean third=false;
        boolean fourth=false;
        if( cr-1>=0 && grid[cr-1][cc]<= grid[cr][cc]){
            first=reachPacific(grid,cr-1,cc,visited);
        }
        if( cc-1>=0 && grid[cr][cc-1]<= grid[cr][cc]){
            second=reachPacific(grid,cr,cc-1,visited);
        }
        if( cc+1<grid[0].length && grid[cr][cc+1]<= grid[cr][cc]){
            third= reachPacific(grid,cr,cc+1,visited);
        }
        if(cr+1<grid.length && grid[cr+1][cc]<= grid[cr][cc]){
            fourth = reachPacific(grid,cr+1,cc,visited);
        }

        return first || second || third || fourth;
    }
    public static boolean reachAtlantic(int[][] grid, int cr, int cc, boolean [][] visited){
       

        int n=grid.length;
        int m= grid[0].length;
        
        if(cr==n-1 || cc==m-1){
            return true;
        }

        if(cc>=grid[0].length || cr>= grid.length || cr<0 || cc<0 || visited[cr][cc]){
            return false;
        }
        visited[cr][cc]= true;
        boolean first=false;
        boolean second=false;
        boolean third=false;
        boolean fourth=false;
        if(cr+1<grid.length && grid[cr+1][cc]<= grid[cr][cc]){
            first = reachAtlantic(grid,cr+1,cc,visited);
        }
        if(cc+1<grid[0].length && grid[cr][cc+1]<= grid[cr][cc]){
            second = reachAtlantic(grid,cr,cc+1,visited);
        }

        if(cr-1>=0 &&grid[cr-1][cc]<= grid[cr][cc]){
            third=reachAtlantic(grid,cr-1,cc,visited);
        }
        if(cc-1>=0 && grid[cr][cc-1]<= grid[cr][cc]){
            fourth=reachAtlantic(grid,cr,cc-1,visited);
        }


        return first || second || third || fourth;

    }

}