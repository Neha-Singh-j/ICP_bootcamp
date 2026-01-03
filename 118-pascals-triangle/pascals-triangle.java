class Solution {
    public List<List<Integer>> generate(int n) {
       List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[n][n];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {   
                curr.add(rec(i, j, dp));
            }
            res.add(curr);
        }

        return res;
    }

    public static int rec(int r, int c, int[][] dp) {

        if (c == 0 || c == r) {
            return 1;
        }

        if (dp[r][c] != -1) return dp[r][c];

        return dp[r][c] = rec(r - 1, c, dp) + rec(r - 1, c - 1, dp);
    }
}


