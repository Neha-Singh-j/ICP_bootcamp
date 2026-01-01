/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        BFT(node);
        return map.get(node);
    }

    public void BFT(Node node) {

        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        q.add(node);

        while (!q.isEmpty()) {

            // 1. remove
            Node curr = q.poll();

            // 2. ignore if visited
            if (visited.contains(curr)) {
                continue;
            }

            // 3. mark visited
            visited.add(curr);

            // 4. self work (clone node)
            map.putIfAbsent(curr, new Node(curr.val));

            // 5. clone neighbors (only create nodes)
            for (Node nbr : curr.neighbors) {
                map.putIfAbsent(nbr, new Node(nbr.val));
            }

            // 6. connect cloned neighbors
            for (Node nbr : curr.neighbors) {
                map.get(curr).neighbors.add(map.get(nbr));
            }

            // 7. add neighbors to queue
            for (Node nbr : curr.neighbors) {
                if (!visited.contains(nbr)) {
                    q.add(nbr);
                }
            }
        }
    }
}
