class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = boxGrid[j][i];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                char temp = grid[i][j];
                grid[i][j] = grid[i][n - j - 1];
                grid[i][n - j - 1] = temp;
            }
        }

        for (int j = 0; j < n; j++) {
            int stone = 0;

            for (int i = 0; i < m; i++) {
                if (grid[i][j] == '#') {
                    stone++;
                    grid[i][j] = '.';
                }

                else if (grid[i][j] == '*') {
                    int idx = i - 1;
                    while (stone > 0) {
                        grid[idx][j] = '#';
                        stone--;
                        idx--;
                    }
                }
            }
            if (stone > 0) {
                int idx = m - 1;
                while (stone > 0) {
                    grid[idx][j] = '#';
                    stone--;
                    idx--;
                }
            }
        }

        return grid;
    }
}