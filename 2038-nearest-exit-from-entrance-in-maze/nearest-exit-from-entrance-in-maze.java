class Solution {
   int [][] dp;
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int n= maze.length;
        int m= maze[0].length;
        int cr= entrance[0];
        int cc= entrance[1];
        ans=Integer.MAX_VALUE;
        dp= new int[n][m];
        for(int []a:dp) Arrays.fill(a,Integer.MAX_VALUE);
        Solve(maze,cr,cc,entrance,0);
        return ans==Integer.MAX_VALUE? -1:ans;
    }
    int ans=Integer.MAX_VALUE;
    public  void Solve(char[][] maze, int cr, int cc, int [] entrance, int c){
        int n=maze.length;
        int m= maze[0].length;
        if(cr<0 || cc<0 || cr>=n || cc>=m){
            return;
        }
        if(c>=dp[cr][cc]){
            return;
        }
        dp[cr][cc]=c;
        if(c>=ans){
            return;
        }
        if(maze[cr][cc]=='+'){
            return;
        }
        if((cr==0 || cr==n-1 || cc==0 || cc==m-1) && (cr!= entrance[0] || cc!=entrance[1]) ){
            ans=Math.min(ans,c);
            return;
        }
        maze[cr][cc]='+';
        Solve(maze,cr+1,cc,entrance,c+1);
        Solve(maze,cr-1,cc,entrance,c+1);
        Solve(maze,cr,cc-1,entrance,c+1);
        Solve(maze,cr,cc+1,entrance,c+1);    
        maze[cr][cc]='.';

    }
}