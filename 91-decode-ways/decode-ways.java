class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return rec(s,0,dp);
    }
    public int rec(String s,int i, int[]dp) {
        if (s.length() == i) return 1;
        if (s.charAt(i) == '0') return 0;
        if(dp[i]!=-1) return dp[i];
        int c = 0;
        c += rec(s,i+1,dp);
        if (i+1 <s.length()) {
            int val = Integer.parseInt(s.substring(i, i+2));
            if (val <= 26) {
                c += rec(s,i+2,dp);
            }
        }
        return dp[i]=c;
    }
}
