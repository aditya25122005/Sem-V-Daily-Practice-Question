class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        boolean [][] visited= new boolean[n][m];
        int[][] best= new int[n][m];
        for(int []A:best) Arrays.fill(A,-1);
        return Solve(grid,health,0,0,visited,best);
    }
    public static boolean Solve(List<List<Integer>> grid, int health, int cr,int cc,boolean [][] visited, int[][] best){
        int n=grid.size();
        int m=grid.get(0).size();

        if(cr<0 || cc<0 || cr>=grid.size() || cc>= grid.get(0).size() || health<=0 || visited[cr][cc]==true){
            return false;
        }
        if(grid.get(cr).get(cc)==1){
            health--;
        }
        if(health<=best[cr][cc]) return false;
        best[cr][cc]=health;
        if(cr==n-1 && cc==m-1 && health>=1){
            return true;
        }
        visited[cr][cc]=true;
        int [] r={-1,1,0,0};
        int [] c={0,0,-1,1};
        boolean res=false;
        for(int i=0;i<r.length;i++){
            res = Solve(grid,health,cr+r[i],cc+c[i],visited,best);
             if(res) return true;
        }
        visited[cr][cc]=false;
        return res;

    }
}