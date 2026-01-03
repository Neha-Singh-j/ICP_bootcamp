class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] arr=new boolean[n];
        for(int i=0;i<edges.length;i++){
            arr[edges[i][1]]=true;
        }
        int idx=-1;
        int c=0;
        for(int i=0;i<n;i++){
            if(!arr[i]){
                idx=i;
                c++;
            }
        }
        if(c>1){
            return -1;
        }
        return idx;
    }
}