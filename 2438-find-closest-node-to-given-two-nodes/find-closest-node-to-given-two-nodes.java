class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        // keep distance of all nodes from nod1,node2
        int[] dis1=new int[edges.length];
        int[] dis2=new int[edges.length];
         Arrays.fill(dis1,-1);
         Arrays.fill(dis2,-1);
         getDis(edges,node1,dis1);
         getDis(edges,node2,dis2);
         int res=-1;
         int minDis=Integer.MAX_VALUE;
         for(int i=0;i<edges.length;i++){
            if(dis1[i]!=-1 && dis2[i]!=-1){
                int curr=Math.max(dis1[i],dis2[i]);
                if(minDis>curr){
                    minDis=curr;
                    res=i;
                }
            }
         }
         return res;
    }
    public static void getDis(int[] arr, int src,int[] dis){
        int idx=src;
        int d=0;
        while(idx!=-1 && dis[idx]==-1){
            dis[idx]=d++;
            idx=arr[idx];
        }
    }
}