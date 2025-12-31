class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //make graph 
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(!map.containsKey(u)){
                map.put(u,new ArrayList<>());
            }
             if(!map.containsKey(v)){
                map.put(v,new ArrayList<>());
            }
            map.get(u).add(v);
            map.get(v).add(u);
        }
        return path(map,source,destination);
    }
    public static boolean path(HashMap<Integer,List<Integer>> map,int src, int des){
        HashSet<Integer> set=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        set.add(src);
        q.add(src);
        while(!q.isEmpty()){
            int r=q.poll();
            if(r==des) return true;
            List<Integer> nbrs=map.getOrDefault(r,new ArrayList<>());
            for(int nbr:nbrs){
                if(!set.contains(nbr)){
                    set.add(nbr);
                    q.add(nbr);
                }
            }
        }
        return false;
    }
}