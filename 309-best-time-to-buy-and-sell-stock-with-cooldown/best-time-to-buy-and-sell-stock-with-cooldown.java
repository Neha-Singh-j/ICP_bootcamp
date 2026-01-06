class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int[]d:dp)
        Arrays.fill(d,-1);
        return bestTime(prices,0,1,dp);
    }
    public int bestTime(int[]arr,int i, int st,int[][]dp){
        if(arr.length<=i) return 0;
        // if(buy then on.y se;; or not sell)
        if(dp[i][st]!=-1) return dp[i][st];
        int p=0;
        if(st==1){
            int buy= (-arr[i])+bestTime(arr,i+1,0,dp);
            int not_buy=bestTime(arr,i+1,1,dp);
            p=Math.max(buy,not_buy);
        }else{
            int sell=arr[i]+bestTime(arr,i+2,1,dp);
            int not_sell=bestTime(arr,i+1,0,dp);
            p=Math.max(sell,not_sell);
        }
        return dp[i][st]=p;
    }
}