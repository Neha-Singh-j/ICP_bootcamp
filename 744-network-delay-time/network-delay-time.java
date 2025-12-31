class Solution {
    private HashMap<Integer,HashMap<Integer,Integer>> map;
    public int networkDelayTime(int[][] times, int n, int k) {
		map=new HashMap<>();
		for(int i=1;i<=n;i++) {
			map.put(i, new HashMap<>());  
		}
        for (int[] t : times) {
            AddEdge(t[0], t[1], t[2]);
        }
		return Dijkstra(n,k);
	}
    public int Dijkstra(int n, int src) {
		PriorityQueue<DijkstraPair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
		HashSet<Integer> visited=new HashSet<>();
		pq.add(new DijkstraPair(src,0));
        int ans=0;
		while(!pq.isEmpty()) {
//			1.remove
			DijkstraPair rp =pq.poll();
//			2. ignore if already visited
			if(visited.contains(rp.vtx)){
				continue;
			}
//			3.Marked visited
			visited.add(rp.vtx);
//          4.add nbrs
            ans=rp.cost;
			for(int nbrs: map.get(rp.vtx).keySet()) {
				 if(!visited.contains(nbrs)) { 
					int cost=map.get(rp.vtx).get(nbrs);
					pq.add(new DijkstraPair(nbrs, rp.cost+cost));
				}
			}
		}
			return visited.size() == n ? ans : -1;
	}
    public void AddEdge(int v1,int v2,int cost) {
		map.get(v1).put(v2, cost);
	}
	
	class DijkstraPair{
		int vtx;
		int cost;
		public DijkstraPair(int vtx, int cost) {
			this.vtx=vtx;
			this.cost=cost;
		}
    }
}