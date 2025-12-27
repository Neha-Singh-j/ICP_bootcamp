class Solution {
    HashMap<Integer,List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            AddEdge(prerequisites[i][0],prerequisites[i][1]);
        }
        return !isCycle();

    }
    public  void AddEdge(int v1,int v2){
        map.get(v1).add(v2);
    }
    public  int[] indegree(){
        int[] in=new int[map.size()];
        for(int c: map.keySet()){
            for(int v2:map.get(c)){
                in[v2]++;
            }
        }
        return in;
    }
    public  boolean isCycle(){
        int[] in=indegree();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0) q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            c++;
            for(int nbrs:map.get(curr)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        return c!=map.size();
    }
}