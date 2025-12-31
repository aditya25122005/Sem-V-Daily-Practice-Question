class Solution {
    public int maximumMinutes(int[][] grid) {
        // 1-> Compute fire time for each cell (BFS)
        // 2-> for 0 to 10^9 check at mid time of delay can we reach dest. (Binary Search)
        // 3-> after mid time delay check can we safely reach to dest (BFS)
        int n = grid.length;
        int m = grid[0].length;
        int[][] fireTime = new int[n][m];
        for (int[] A : fireTime) {
            Arrays.fill(A, Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[] { i, j });
                    fireTime[i][j] = 0;
                }
            }
        }
        int[] r = { -1, 1, 0, 0 };
        int[] c = { 0, 0, -1, 1 };
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int[] rm = q.poll();
                for (int i = 0; i < r.length; i++) {
                    int nr = rm[0] + r[i];
                    int nc = rm[1] + c[i];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] != 2
                            && fireTime[nr][nc] == Integer.MAX_VALUE) {
                        q.add(new int[] { nr, nc });
                        fireTime[nr][nc] = time + 1;
                    }
                }
            }
            time++;
        }

        int lo = 0;
        int hi = 1000000000;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            boolean[][] visited = new boolean[n][m];
            if (isPossible(mid, fireTime, grid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;

    }

    public static boolean isPossible(int mid, int[][] fireTime, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (fireTime[0][0] <= mid)
            return false;

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[] { 0, 0 });
        int[] r = { -1, 1, 0, 0 };
        int[] c = { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] rm = q.poll();
                if (rm[0] == n - 1 && rm[1] == m - 1)
                    return true;
                for (int i = 0; i < r.length; i++) {
                    int nr = r[i] + rm[0];
                    int nc = c[i] + rm[1];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                        continue;
                    if (visited[nr][nc])
                        continue;
                    if (grid[nr][nc] == 2)
                        continue;

                    int personTime = 1 + time + mid;
                    if (nr == n - 1 && nc == m - 1) {
                        if (personTime <= fireTime[nr][nc]) {
                            visited[nr][nc] = true;
                            q.add(new int[] { nr, nc });
                        }
                    } else {
                        if (personTime < fireTime[nr][nc]) {
                            visited[nr][nc] = true;
                            q.add(new int[] { nr, nc });
                        }
                    }

                }

            }
            time++;
        }
        return false;
    }
}