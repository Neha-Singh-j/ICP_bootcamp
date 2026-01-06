class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> set = new HashSet<>();
        for (int c : forbidden) {
            set.add(c);
        }
        return minJumps(a, b, x, set);

    }

    public int minJumps(int a, int b, int x, HashSet<Integer> set){
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[6001][2];
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                 // 1. remove
            int[] r = q.poll();
            int pos = r[0];
            int back = r[1];
            // 4. self work
            if (pos == x) return steps;
            // 5. add neighbors
            // forward jump
            int f = pos + a;
            if (f <= 6000 && !set.contains(f) && !visited[f][0]) {
                visited[f][0] = true;
                q.add(new int[]{f, 0});
            }

            int bk = pos - b;
            if (back == 0 && bk >= 0 && !set.contains(bk) && !visited[bk][1]) {
                visited[bk][1] = true;
                q.add(new int[]{bk, 1});
            }
        }
        steps++; // level completed
    }
    return -1;
}
}