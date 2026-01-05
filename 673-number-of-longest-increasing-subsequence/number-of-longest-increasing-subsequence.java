class Solution {
    public int findNumberOfLIS(int[] arr) {
        int[] dp=new int[arr.length];
        int[] freq=new int[arr.length];
        Arrays.fill(dp,1);
        Arrays.fill(freq,1);
        for(int i=1;i<dp.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    int x=dp[j];
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        freq[i]=freq[j];
                    }
                    else if (dp[j] + 1 == dp[i]) {
                        freq[i] += freq[j];   // add ways
                    }
                }
            }
        }
        int max=Arrays.stream(dp).max().getAsInt();
        int c=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]==max) //length of lis is max then only add freq ( no. of path to get same length lis)
            c+=freq[i];
        }
        return c;
    }
}