class Solution {
    int score=0;
    public int maxOperations(int[] nums) {
       
        int n = nums.length;
        int ans = 0;
        //1 for start two deltion
        score = nums[0] + nums[1];
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        ans = Math.max(ans, solve(0, n - 1,nums,dp));
        //2 for last two delteions
        score = nums[n - 2] + nums[n - 1];
        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        ans = Math.max(ans, solve(0, n - 1,nums,dp));

        // 3) first and last
        score = nums[0] + nums[n - 1];
        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        ans = Math.max(ans, solve(0, n - 1,nums,dp));

        return ans;
    }

    private int solve(int l, int r,int[]nums, int[][]dp) {
        if (r - l + 1 < 2) return 0;
        if (dp[l][r] != -1) return dp[l][r];

        int res = 0;

        if (l + 1 <= r && nums[l] + nums[l + 1] == score) {
            res = Math.max(res, 1 + solve(l + 2, r,nums,dp));
        }

        if (l <= r - 1 && nums[r - 1] + nums[r] == score) {
            res = Math.max(res, 1 + solve(l, r - 2,nums,dp));
        }

        if (nums[l] + nums[r] == score) {
            res = Math.max(res, 1 + solve(l + 1, r - 1,nums,dp));
        }

        return dp[l][r] = res;
    }
}
