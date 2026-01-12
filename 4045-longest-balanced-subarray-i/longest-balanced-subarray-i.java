class Solution {
    public int longestBalanced(int[] nums) {
        int[] tavernilo = nums; 
        int n = nums.length;
        int maxLen = 0;

         for (int i = 0; i < n; i++) {
            HashSet<Integer> s1 = new HashSet<>();
            HashSet<Integer> s2 = new HashSet<>();
            for (int j = i; j < n; j++) {
                int num = tavernilo[j];
                if (num % 2 == 0) {
                    s1.add(num);
                } else {
                    s2.add(num);
                }
                 if (s1.size() == s2.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
