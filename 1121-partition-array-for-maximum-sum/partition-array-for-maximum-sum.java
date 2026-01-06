class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return partition(arr,k,0,dp);
    }
    public int partition(int[] arr, int k, int idx,int[]dp){
        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int sum=0;
        int len=0;
        int max=0;
        int ans=Integer.MIN_VALUE;
        for(int i=idx;i<arr.length && len<k ;i++){
            len++;
            max=Math.max(arr[i],max);

            sum=len*max+partition(arr, k,i+1,dp);
            ans=Math.max(ans,sum);
        }
        return dp[idx]=ans;
    }
}