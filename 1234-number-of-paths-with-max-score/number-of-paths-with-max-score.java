class Solution {
    static int mod=1000000007;
    public int[] pathsWithMaxScore(List<String> board) {
        
        int []ans= new int[2];
        int m=board.get(0).length();
        int n=board.size();
        mod=1000000007;
       
        int[][] dp= new int[n][m];
        
        
        for(int [] A:dp){
            Arrays.fill(A,-1);
        }
        char[][] grid= new char[board.size()][board.get(0).length()];
        for(int i=0;i<grid.length;i++){
            String s=board.get(i);
            for(int j=0;j<m;j++){
                grid[i][j]=s.charAt(j);
            }
        }
        ans[0] = Solve(grid,n-1,m-1,dp);
        if(ans[0]<0) return new int[]{0,0};
        int[][][] dp2= new int[n][m][ans[0]+1];
        for(int i=0;i<dp2.length;i++){
            for(int []A:dp2[i]){
                Arrays.fill(A,-1);
            }
        }
        
        ans[1]= numPath(grid,n-1,m-1,ans[0],0,dp2)%mod;
        return ans;

    }
    public static int Solve(char[][] grid, int cr, int cc,int[][]dp){
        if(cr<0 || cc<0 || grid[cr][cc]=='X'){
            return -1000000000;
        }
        if(cr==0 && cc==0){
            return 0;
        }
        if(dp[cr][cc]!=-1) return dp[cr][cc];
        int val=0;
        if(grid[cr][cc]!='S'){
            val=grid[cr][cc]-'0';
        }
        else{
            val=0;
        }
        
        int a=Solve(grid,cr-1,cc-1,dp);
        int b=Solve(grid,cr,cc-1,dp);
        int c=Solve(grid,cr-1,cc,dp);

        return dp[cr][cc] =val+ Math.max(a,Math.max(b,c)) ;
    }
   
    public static int numPath(char[][] grid, int cr, int cc, int ans, long curr, int[][][]dp){
        if(cr<0 || cc<0 || grid[cr][cc]=='X'){
            return 0;
        }
        
        if(cr==0 && cc==0){
            if(curr==ans)return 1;
            return 0;
        }
        if(grid[cr][cc]!='S' && grid[cr][cc]!='E'){
            curr+= grid[cr][cc]-'0';
        }
        if(curr>ans) return 0;
        if(dp[cr][cc][(int)curr]!=-1) return dp[cr][cc][(int)curr];
        long cnt=0;
        cnt+=numPath(grid,cr-1,cc-1,ans,curr,dp);
        cnt+=numPath(grid,cr,cc-1,ans,curr,dp);
        cnt+=numPath(grid,cr-1,cc,ans,curr,dp);
        return dp[cr][cc][(int)curr]=(int)cnt %mod;

    }
}