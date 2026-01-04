class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

            int curr= rec(word1, word2, 0, 0, dp);
            return word1.length()+word2.length()-2*curr;
    }
     public int rec(String t1, String t2, int i, int j, int[][] dp) {
        if (i == t1.length() || j == t2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (t1.charAt(i) == t2.charAt(j)) {
            dp[i][j] = 1 + rec(t1, t2, i + 1, j + 1, dp);
        } else {
            int a = rec(t1, t2, i + 1, j, dp);
            int b = rec(t1, t2, i, j + 1, dp);
            dp[i][j] = Math.max(a, b);
        }

        return dp[i][j];
    }
}