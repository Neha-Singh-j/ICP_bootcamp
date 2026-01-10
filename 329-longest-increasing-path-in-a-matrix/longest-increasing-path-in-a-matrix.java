class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][]dp=new int[n][m];
        for(int[]d:dp)
            Arrays.fill(d,-1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, lip(matrix, i, j, dp));
            }
        }
        return ans;
       
    }
    public int lip(int[][]arr,int i, int j, int[][]dp){
        if(i>=arr.length || j>=arr[0].length || i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int a=1;
         if (i + 1 < arr.length && arr[i + 1][j] > arr[i][j])
            a = Math.max(a, 1 + lip(arr, i + 1, j, dp));

        if (i - 1 >= 0 && arr[i - 1][j] > arr[i][j])
            a = Math.max(a, 1 + lip(arr, i - 1, j, dp));

        if (j + 1 < arr[0].length && arr[i][j + 1] > arr[i][j])
            a = Math.max(a, 1 + lip(arr, i, j + 1, dp));

        if (j - 1 >= 0 && arr[i][j - 1] > arr[i][j])
            a = Math.max(a, 1 + lip(arr, i, j - 1, dp));
         return dp[i][j]=a;

    }
}