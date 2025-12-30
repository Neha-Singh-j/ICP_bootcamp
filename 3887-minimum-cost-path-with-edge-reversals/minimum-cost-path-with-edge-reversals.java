class Solution {
    private HashMap<Integer, HashMap<Integer, Integer>> map;
    public int minCost(int n, int[][] edges) {
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }

        // build graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            AddEdge(u, v, w);
        }
        return Dijkstra(0, n - 1);
    }

    // original + reversed edge
    public void AddEdge(int u, int v, int cost) {
        //hanlding conditon of if rev also given then take min cost one
          map.get(u).put(
        v,
        Math.min(map.get(u).getOrDefault(v, Integer.MAX_VALUE), cost)
    );

    // reversed direction
    map.get(v).put(
        u,
        Math.min(map.get(v).getOrDefault(u, Integer.MAX_VALUE), 2 * cost)
    );
    }

    class DijkstraPair {
        int vtx;
        int cost;
        public DijkstraPair(int vtx, int cost) {
            this.vtx = vtx;
            this.cost = cost;
        }
    }

    public int Dijkstra(int src, int dest) {

        PriorityQueue<DijkstraPair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        int[] dist = new int[map.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new DijkstraPair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {

            DijkstraPair rp = pq.poll();

            if (rp.vtx == dest) return rp.cost;

            if (rp.cost > dist[rp.vtx]) continue;

            for (int nbr : map.get(rp.vtx).keySet()) {
                int newCost = rp.cost + map.get(rp.vtx).get(nbr);

                if (newCost < dist[nbr]) {
                    dist[nbr] = newCost;
                    pq.add(new DijkstraPair(nbr, newCost));
                }
            }
        }
        return -1;
    }
}
