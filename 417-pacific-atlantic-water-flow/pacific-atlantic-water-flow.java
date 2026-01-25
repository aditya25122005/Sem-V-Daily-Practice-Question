class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ll= new ArrayList<>();

        int n= heights.length;
        int m= heights[0].length;
        boolean [][] reachPacific= new boolean[n][m];
        boolean [][] reachAtlantic = new boolean[n][m];

        int r=0;
        for(int j=0;j<m;j++){
            Pacific(heights,reachPacific,r,j);
        }
        int c=0;
        for(r=0;r<n;r++){
            Pacific(heights,reachPacific,r,c);
        }


        r=n-1;
        for(int j=0;j<m;j++){
            Atlantic(heights,reachAtlantic,r,j);
        }
        c=m-1;
        for(r=0;r<n;r++){
            Atlantic(heights,reachAtlantic,r,c);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(reachPacific[i][j] && reachAtlantic[i][j]){
                    ll.add(Arrays.asList(i,j));
                }
            }
        }
    return ll;

    }
    public static void Pacific(int [][] grid, boolean[][] canReach, int cr, int cc){
        int [] r={-1,1,0,0};
        int [] c={0,0,1,-1};
        if(canReach[cr][cc]){
            return;
        } 
        canReach[cr][cc]=true;
        for(int k=0;k<r.length;k++){
            int nr= cr+r[k];
            int nc= cc+c[k];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]>=grid[cr][cc]){
                Pacific(grid,canReach,nr,nc);
            }
        }
    }

    public static void Atlantic(int [][] grid, boolean[][] canReach, int cr, int cc){
        int [] r={-1,1,0,0};
        int [] c={0,0,1,-1};
        if(canReach[cr][cc]){
            return;
        } 
        canReach[cr][cc]=true;
        for(int k=0;k<r.length;k++){
            int nr= cr+r[k];
            int nc= cc+c[k];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]>=grid[cr][cc]){
                Atlantic(grid,canReach,nr,nc);
            }
        }
    }
}