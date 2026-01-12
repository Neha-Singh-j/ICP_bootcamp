class Solution {
    public int minimumOperations(int[] nums) {
       int n = nums.length;
        Map<Integer, Integer> even = new HashMap<>();
        Map<Integer, Integer> odd = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            else
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
        }

        int[][] e = topTwo(even);
        int[][] o = topTwo(odd);

        int maxKept = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (e[i][0] != o[j][0]) {
                    maxKept = Math.max(maxKept, e[i][1] + o[j][1]);
                }
            }
        }

        return n - maxKept;
    }

    private int[][] topTwo(Map<Integer, Integer> map) {
        int[][] res = {{-1, 0}, {-1, 0}};
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > res[0][1]) {
                res[1] = res[0];
                res[0] = new int[]{key, freq};
            } else if (freq > res[1][1]) {
                res[1] = new int[]{key, freq};
            }
        }
        return res;
    }
}
