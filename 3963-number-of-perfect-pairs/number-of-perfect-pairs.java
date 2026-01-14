class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long c = 0;
        long ans = 0;

         int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(nums[i]);
        }
        Arrays.sort(arr);
        int j = 0;
        for (int i = 0; i < n; i++) {
            // move j until condition satisfied
            while (arr[i] > 2L * arr[j]) {
                j++;
            }
            ans += (i - j);
        }

        return ans;
    }
}

