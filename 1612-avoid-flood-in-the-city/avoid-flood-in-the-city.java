class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
         int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Map<Integer, Integer> prev = new HashMap<>();
        TreeSet<Integer> dry = new TreeSet<>(); //get dry days in shorted manner

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dry.add(i);
                ans[i] = 1;
            } else {
                int lake = rains[i];
                if (prev.containsKey(lake)) {
                    Integer dryDay = dry.ceiling(prev.get(lake));
                    if (dryDay == null) return new int[0];

                    ans[dryDay] = lake;
                    dry.remove(dryDay);
                }
                prev.put(lake, i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}