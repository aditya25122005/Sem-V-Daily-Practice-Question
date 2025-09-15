class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        // for(boolean [] a:dp){
        //     Arrays.fill(a,null);
        // }
        return solve(s1, s2, s3, 0, 0, 0, dp);

    }

    public static boolean solve(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp) {

        if (s1.length() + s2.length() != s3.length())
            return false;
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }
        if (dp[i][j] != null)
            return dp[i][j];
        boolean valid = false;

        if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
            valid = solve(s1, s2, s3, i + 1, j, k + 1, dp);
        }
        if (!valid && j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
            valid = solve(s1, s2, s3, i, j + 1, k + 1, dp);
        }
        return dp[i][j] = valid;

    }
}