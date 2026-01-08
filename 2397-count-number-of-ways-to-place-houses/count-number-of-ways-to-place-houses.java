class Solution {
    static int MOD = 1000000007;
    public int countHousePlacements(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        long ways = climb(n, dp);   // one side
        return (int)((ways * ways) % MOD);
    }

    public static int climb(int n, int[] dp) {
        if (n == 0) return 1;
        if (n == 1) return 2;  
        if (n < 0) return 0;

        if (dp[n] != -1) return dp[n];
        int a = climb(n - 1, dp);
        int b = climb(n - 2, dp);

        return dp[n] = (a + b) % MOD;
    }
}
