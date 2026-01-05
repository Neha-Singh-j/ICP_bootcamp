class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        
        int curr=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                curr=Math.max(curr,count(matrix,i,j,dp));
            }
        }
        return curr*curr;
    }
    public static int count(char[][]arr, int i, int j,int[][]dp){
        if(i>=arr.length ||i<0 || j<0 || j>=arr[0].length) return 0;
        if(arr[i][j]=='0') return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int a=count(arr,i-1,j-1,dp);
        int b=count(arr,i-1,j,dp);
        int c=count(arr,i,j-1,dp);
        return dp[i][j]=Math.min(Math.min(a,b),c)+1;
    }
}