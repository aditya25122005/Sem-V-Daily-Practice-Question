class Solution {
    int n;
    int m;
    int k;
    int mod;

    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();
        m = board.get(0).length();
        mod = 1000000007;

        char[][] grid = new char[n][m];
        for(int i=0;i<n;i++){
            String s = board.get(i);
            for(int j=0;j<m;j++){
                grid[i][j] = s.charAt(j);
            }
        }

        Integer[][] dp = new Integer[n][m];
        int ans = Solve(grid,n-1,m-1,dp);
        k = ans;
        if(ans<0) return new int[]{0,0};
        Integer[][][] dp2 = new Integer[n][m][ans+1];
        
        int ans2 = Solve2(grid,n-1,m-1,0,dp2);
        if(ans2==0){
            return new int[]{0,0};
        }
        return new int[]{ans, ans2};


    }
    public  int Solve2(char[][] grid, int cr, int cc, int sum,Integer[][][] dp2){
        if(cr<0 || cc<0 || grid[cr][cc]=='X' || sum>k){
            return 0;
        }
        if(cr==0 && cc==0){
            if(sum==k){
                return 1;
            }
            return 0;
        }

        sum+= (cr==n-1 && cc==m-1)? 0: grid[cr][cc]-'0';

        if(dp2[cr][cc][sum] != null) return dp2[cr][cc][sum];

        int A = Solve2(grid,cr-1,cc,sum,dp2);
        int B = Solve2(grid,cr-1,cc-1,sum,dp2);
        int C = Solve2(grid,cr,cc-1,sum,dp2);

        return dp2[cr][cc][sum] = (A + B + C)%mod;
    }

    public int Solve(char[][] grid, int cr, int cc,Integer[][] dp ){
        if(cr<0 || cc<0 || grid[cr][cc]=='X'){
            return Integer.MIN_VALUE;
        }
        if(cr==0 && cc==0){
            return 0;
        }
        if(dp[cr][cc]!=null) return dp[cr][cc];
        int add = (cr==n-1 && cc==m-1)? 0: grid[cr][cc]-'0';
        int A = add + Solve(grid,cr-1,cc,dp);
        int B = add + Solve(grid,cr-1,cc-1,dp);
        int C = add + Solve(grid,cr,cc-1,dp);

        return dp[cr][cc] = Math.max(A,Math.max(B,C));
       
    }
}