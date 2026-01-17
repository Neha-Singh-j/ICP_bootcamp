class Solution {

    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        // add edges
        for (int[] e : edges) {
            AddEdge(e[0], e[1], e[2]);
        }

        return Dijkstra(n, disappear);
    }

    public void AddEdge(int v1, int v2, int cost) {

        map.get(v1).put(v2,
            Math.min(map.get(v1).getOrDefault(v2, Integer.MAX_VALUE), cost));

        map.get(v2).put(v1,
            Math.min(map.get(v2).getOrDefault(v1, Integer.MAX_VALUE), cost));
    }


    class DijkstraPair {
        int vtx;
        int cost;

        public DijkstraPair(int vtx, int cost) {
            this.vtx = vtx;
            this.cost = cost;
        }
    }

    public int[] Dijkstra(int n, int[] disappear) {

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        PriorityQueue<DijkstraPair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        boolean[] visited = new boolean[n];

        pq.add(new DijkstraPair(0, 0));

        while (!pq.isEmpty()) {

            DijkstraPair rp = pq.poll();

            if (visited[rp.vtx]) continue;

            // vanish check
            if (rp.cost >= disappear[rp.vtx]) continue;

            visited[rp.vtx] = true;
            ans[rp.vtx] = rp.cost;

            for (int nbr : map.get(rp.vtx).keySet()) {
                if (!visited[nbr]) {
                    int newCost = rp.cost + map.get(rp.vtx).get(nbr);
                    pq.add(new DijkstraPair(nbr, newCost));
                }
            }
        }
        return ans;
    }
}
