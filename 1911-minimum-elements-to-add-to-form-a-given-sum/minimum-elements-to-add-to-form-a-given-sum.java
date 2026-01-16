class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum=0;
        for (int x : nums) {
            sum += x;
        }
        
        long d = Math.abs(goal - sum);
        if (d == 0) return 0;
        return (int) ((d + limit - 1) / limit);
    }
}