class Solution {
    public boolean validPartition(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];

        return solve(0, nums, dp);
    }

    boolean solve(int i, int[] nums, Boolean[] dp) {
        if (i == nums.length) return true;
        if (dp[i] != null) return dp[i];
        
        boolean res = false;
        // Case 1: two equal elements
        if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            res |= solve(i + 2, nums, dp);
        }
        // Case 2: three equal elements
        if (i + 2 < nums.length &&
            nums[i] == nums[i + 1] &&
            nums[i + 1] == nums[i + 2]) {
            res |= solve(i + 3, nums, dp);
        }
        // Case 3: three consecutive increasing elements
        if (i + 2 < nums.length &&
            nums[i + 1] == nums[i] + 1 &&
            nums[i + 2] == nums[i] + 2) {
            res |= solve(i + 3, nums, dp);
        }
        return dp[i] = res;
    }
}
