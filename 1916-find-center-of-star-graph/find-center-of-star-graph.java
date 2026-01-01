class Solution {
    public int findCenter(int[][] edges) {
        //conditons is defined 1 is common in all then its comoon also in first 2 nodes....just return 
        if(edges[0][1]==edges[1][0] || edges[0][1]==edges[1][1]){
            return edges[0][1];
        }
        return edges[0][0];
    }
}