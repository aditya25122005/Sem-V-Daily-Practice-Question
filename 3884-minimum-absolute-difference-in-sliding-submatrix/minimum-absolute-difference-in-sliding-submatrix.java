class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;

        int [][] ans= new int[n-k+1][m-k+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i+k<=n && j+k<=m){
                    ans[i][j] = Solve(grid, i, j, k);
                }
            }
        }
        return ans;
    }
    public static int Solve(int [][] grid, int sr, int sc,int k){
        List<Integer> ll = new ArrayList<>();
        HashSet<Integer> hh= new HashSet<>();
        for(int i=sr;i<k+sr;i++){
            for(int j=sc;j<sc+k;j++){
                hh.add(grid[i][j]);
            }
        }
        for(int num: hh) ll.add(num);
       
        Collections.sort(ll);
        //System.out.println(ll);
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<ll.size()-1;i++){
            diff=Math.min(diff,Math.abs(ll.get(i)-ll.get(i+1)));
        }
        return diff==Integer.MAX_VALUE? 0 : diff;
    }
}