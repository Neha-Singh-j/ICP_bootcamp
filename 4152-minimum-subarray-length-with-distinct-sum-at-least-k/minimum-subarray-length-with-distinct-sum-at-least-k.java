class Solution {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int st = 0;
        int curr = k;           // remaining required sum
        int len = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            int x = nums[end];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 1) {
                curr -= x;
            }
            while (curr <= 0) {
                len = Math.min(len, end - st + 1);
                int y = nums[st];
                cnt.put(y, cnt.get(y) - 1);
                if (cnt.get(y) == 0) {
                    curr += y;
                }
                st++;
            }
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }
}
