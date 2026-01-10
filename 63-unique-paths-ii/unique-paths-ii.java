class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, obstacleGrid, dp);
    }

    public int solve(int r, int c, int[][] grid, int[][] dp) {
        if (r >= grid.length || c >= grid[0].length || grid[r][c] == 1)
            return 0;
        
        if (r == grid.length - 1 && c == grid[0].length - 1)
            return 1;
        
        if (dp[r][c] != -1)
            return dp[r][c];
        
        int right = solve(r, c + 1, grid, dp);
        int down = solve(r + 1, c, grid, dp);
        
        return dp[r][c] = right + down;
    }
}
