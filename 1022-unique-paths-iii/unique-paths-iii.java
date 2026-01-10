class Solution {
    public int uniquePathsIII(int[][] maze) {
        int n=maze.length;
        int m=maze[0].length;
        int zc=0;
        int sr=0,sc=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maze[i][j]==0) zc++;
                 if(maze[i][j]==1){
                    sr=i;
                    sc=j;
                }
            }
        }
		return print(maze,sr,sc,0,zc);
    }
    
    public static int  print(int[][] maze,int cr,int cc,int c, int zc) {
            if(cc<0||cr<0|| cr>=maze.length||cc>=maze[0].length || maze[cr][cc]==-1) {
                 return 0;
             }
        
        if(maze[cr][cc]==2 && zc==c) return 1;
        int temp=maze[cr][cc];
        if(maze[cr][cc]==0) c++;
        int ways=0;
        maze[cr][cc]=-1; //revisiting not allowed so block ways
        ways+=print(maze,cr-1,cc,c,zc);
        ways+=print(maze,cr,cc-1,c,zc);
        ways+=print(maze,cr+1,cc,c,zc);
        ways+=print(maze,cr,cc+1,c,zc);
        maze[cr][cc]=temp;
        return ways;
    }
}