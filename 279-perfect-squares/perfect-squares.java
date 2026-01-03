class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return rec(n,0,dp);
    }
    public int rec(int n,int curr,int[]dp){
        if(curr>n) return Integer.MAX_VALUE;
        if(curr==n) return 0;
        if(dp[curr]!=-1) return dp[curr];
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int c=Math.min(rec(n,curr+i*i,dp),min);
            if (c != Integer.MAX_VALUE) {
                min = Math.min(min, c + 1);
            }
        }
        return dp[curr]=min;
    }
}