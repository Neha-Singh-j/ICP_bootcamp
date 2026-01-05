class Solution {
       Set<String> dict;
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        Boolean[]dp=new Boolean[s.length()];
       return canBreak(s,0,dp);
}

public  boolean canBreak(String s,int j,Boolean[]dp) {
    if (s.length() == j) return true;
    if(dp[j]!=null) return dp[j];
    for (int i = j+1; i <= s.length(); i++) {
            String prefix = s.substring(j, i);
            if(dict.contains(prefix) && canBreak(s,i,dp)) {
                return dp[j]=true;
            }
        }
        return dp[j]= false;
    }
}