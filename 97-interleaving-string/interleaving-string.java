class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return interleave(s1, s2, s3, 0, 0, 0, dp);
    }

    public boolean interleave(String s1, String s2, String s3,
                              int i, int j, int k, Boolean[][] dp) {

        // reached end of s3
        if (k == s3.length()) return true;

        // memoization check
        if (dp[i][j] != null) return dp[i][j];

        boolean a = false, b = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            a = interleave(s1, s2, s3, i + 1, j, k + 1, dp);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            b = interleave(s1, s2, s3, i, j + 1, k + 1, dp);
        }

        return dp[i][j] = a || b;
    }
}
