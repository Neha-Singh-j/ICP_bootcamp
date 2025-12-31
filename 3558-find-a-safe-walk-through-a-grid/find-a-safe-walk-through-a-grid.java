class Solution {
    static int[][] dp;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        dp=new int[grid.size()][grid.get(0).size()];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return dfs(grid,health,0,0);
    }
    public static boolean dfs(List<List<Integer>> grid,int health, int i, int j){
        if(i<0||j<0||i>=grid.size()||j>=grid.get(0).size()){
            return false;
        }
        if(grid.get(i).get(j)==1) health--;

        if(health<1) return false; //already get exhausted

        if(i==grid.size()-1 && j==grid.get(0).size()-1 && health>=1) return true; 

        if(dp[i][j]>=health) return false; 
        dp[i][j]=health;
        return (dfs(grid,health,i+1,j) ||
        dfs(grid,health,i-1,j) ||
        dfs(grid,health,i,j-1) ||
        dfs(grid,health,i,j+1) );
        

    }
}