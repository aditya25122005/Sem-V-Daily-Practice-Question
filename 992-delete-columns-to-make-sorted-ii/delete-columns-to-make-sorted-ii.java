class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs[0].length();
        int n = strs.length;
        int delete = 0;
        boolean[] fixed = new boolean[n - 1];
        for (int col = 0; col < m; col++) {
            boolean deleteCol = false;
            for (int row = 0; row < n - 1; row++) {
                if (!fixed[row] && strs[row].charAt(col) > strs[row+1].charAt(col)) {
                    deleteCol = true;
                    break;
                }
            }
            if (deleteCol) {
                delete++;
                continue;
            }

            for (int row = 0; row < n - 1; row++) {
                if (!fixed[row] && strs[row].charAt(col) < strs[row+1].charAt(col)) {
                    fixed[row] = true;
                }
            }

        }
        return delete;

    }
}