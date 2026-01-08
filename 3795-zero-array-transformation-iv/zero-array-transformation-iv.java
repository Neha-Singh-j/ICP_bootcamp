class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int ans = -1;
        for(int i = 0; i < nums.length; ++i){
            int[][] dp = new int[nums[i]+1][queries.length];
            for(int[]d:dp){
                Arrays.fill(d,-1);
            }
            ans = Math.max(ans, solve(queries, i, nums[i], 0, dp));
        }
        return (ans > queries.length)?-1: ans;
    }
    public  int solve(int[][] q, int i, int target, int k, int[][] dp){
        if(target == 0) return k;         
        if(k >= q.length || target < 0) return q.length + 1;   

        if(dp[target][k] != -1) return dp[target][k];
        int res = solve(q, i, target, k+1, dp);   

        if(q[k][0] <= i && i <= q[k][1]){

            res = Math.min(res, solve(q, i, target - q[k][2], k+1, dp)); 
        }
        return dp[target][k] = res;
    }
}

