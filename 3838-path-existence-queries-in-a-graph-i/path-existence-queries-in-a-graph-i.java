class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        //grp alll the indes compent wise then check if both index belongs to same competent in queries then true toherwise false
        int com = 1; // name component
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, com);

        for (int i = 0; i < nums.length - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) <= maxDiff) {
                m.put(i, com);
                m.put(i + 1, com);
            } else {
                com++;
                m.put(i + 1, com);
            }
        }

        boolean[] v = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int w = queries[i][1];
            int cu = m.getOrDefault(u, 0);
            int cv = m.getOrDefault(w, 0);

            if (cu == cv) {
                v[i] = true;
            }
        }

        return v;
    }
}
