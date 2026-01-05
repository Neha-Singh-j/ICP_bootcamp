class Solution {
    public int minimumBuckets(String hamsters) {
        int[] dp=new int[hamsters.length()];
        Arrays.fill(dp,-1);
        int ans=feedHam(hamsters.toCharArray(),0,dp);
        if(ans >= 1000000){
            return -1;
        }
        return ans;
    }
    public int feedHam(char[] arr, int i,int[]dp){
        if(i>=arr.length) return 0;

        if(dp[i]!=-1) return dp[i];
        //not a hamster no need to feed
        if(arr[i]!='H')
            return dp[i]=feedHam(arr,i+1,dp);

        if (i - 1 >= 0 && arr[i - 1] == 'B') { //a;ready bucket in left kept for previous hamster
            return dp[i] = feedHam(arr, i + 1, dp);
        }

        int a=1000000;
         if (i + 1 < arr.length && arr[i + 1] == '.'){
            arr[i+1]='B';
            a=Math.min(a,feedHam(arr,i+1,dp)+1);
            arr[i+1]='.';//backtrack;
         }
        if (i - 1 >= 0 && arr[i - 1] == '.') {
            arr[i-1]='B';
            a=Math.min(a,feedHam(arr,i+1,dp)+1);
            arr[i-1]='.';//backtrack;
        }
           

        return dp[i]=a;
    }
}