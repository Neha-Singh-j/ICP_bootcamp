class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
       List<List<Integer>> graph = new ArrayList<>();

        // initialize adjacency list
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges
        for (int i = 0; i < dislikes.length; i++) {
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return isBipartite(graph);
    }
    public boolean isBipartite(List<List<Integer>> graph) {
			
			Queue<BipartitePair> q = new LinkedList<>();
			HashMap<Integer, Integer> visited = new HashMap<>();
			for (int i = 0; i < graph.size(); i++) {// vtx
				if (visited.containsKey(i)) {
					continue;
				}
				q.add(new BipartitePair(i, 0));
				while (!q.isEmpty()) {
					// 1. remove
					BipartitePair rp = q.poll();
					// 2. Ignore if Alredv visited
					if (visited.containsKey(rp.vtx)) {
						if (visited.get(rp.vtx) != rp.dis) {
							return false;
						}
						continue;

					}
					// 3. makred visited
					visited.put(rp.vtx, rp.dis);
					// 4. self work
					 
					// 5. Add unvisited nbrs
					for (int nbrs : graph.get(rp.vtx)) {
						if (!visited.containsKey(nbrs)) {
							q.add(new BipartitePair(nbrs, rp.dis + 1));
						}
					}
				}
			}
			return true;

		}
        class BipartitePair {
		int vtx;
		int dis;

		public BipartitePair(int vtx, int dis) {
			// TODO Auto-generated constructor stub
			this.vtx = vtx;
			this.dis = dis;
		}
	}
}