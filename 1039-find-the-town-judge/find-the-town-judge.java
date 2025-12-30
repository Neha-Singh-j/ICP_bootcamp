class Solution {
    public int findJudge(int n, int[][] trust) {
        //maintaining indegree and outdegree of every 1 to n peoples 
        int []nposs = new int[n+1]; //if frq n-1 then all trust him
        int []poss = new int[n+1]; // can  be jusge if frq=0
        for(int i=0; i<trust.length; i++) {
            nposs[trust[i][1]]++;
            poss[trust[i][0]]++;
        }
        for(int i=1; i<=n;i++) {
            if(poss[i]==0 && nposs[i]==(n-1)) 
                return i; //that celebrity founded both constion satisifed
        }
        return -1;
    }
}