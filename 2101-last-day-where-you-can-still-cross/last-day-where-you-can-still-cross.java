class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int ans = 0;
        int n = cells.length;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int[][] grid = new int[row][col];
            int mid = lo + (hi - lo) / 2;
            for (int i = mid; i >= 0; i--) {
                int r = cells[i][0] - 1;
                int c = cells[i][1] - 1;
                grid[r][c] = 1;
            }
            boolean[][] visited = new boolean[row][col];
            boolean flag = false;
            for (int i = 0; i < col; i++) {
                if (grid[0][i] == 0 && Solve(0, i, grid, visited)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                ans = mid + 1;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }
        return ans;

    }

    public static boolean Solve(int cr, int cc, int[][] grid, boolean[][] visited) {
        if (cr < 0 || cc < 0 || cr >= grid.length || cc >= grid[0].length || grid[cr][cc] == 1 || visited[cr][cc]) {
            return false;
        }
        if (cr == grid.length - 1) {
            return true;
        }
        visited[cr][cc] = true;
        int[] d1 = { -1, 1, 0, 0 };
        int[] d2 = { 0, 0, -1, 1 };
        boolean res = false;
        for (int i = 0; i < d1.length; i++) {
            res = Solve(cr + d1[i], cc + d2[i], grid, visited);
            if (res)
                return true;
        }
        // visited[cr][cc] = false;
        return res;
    }
}