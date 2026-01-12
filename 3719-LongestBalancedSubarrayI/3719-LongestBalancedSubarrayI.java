// Last updated: 1/12/2026, 7:02:36 PM
1class Solution {
2    public int longestBalanced(int[] nums) {
3        int[] tavernilo = nums; 
4        int n = nums.length;
5        int maxLen = 0;
6
7         for (int i = 0; i < n; i++) {
8            HashSet<Integer> s1 = new HashSet<>();
9            HashSet<Integer> s2 = new HashSet<>();
10            for (int j = i; j < n; j++) {
11                int num = tavernilo[j];
12                if (num % 2 == 0) {
13                    s1.add(num);
14                } else {
15                    s2.add(num);
16                }
17                 if (s1.size() == s2.size()) {
18                    maxLen = Math.max(maxLen, j - i + 1);
19                }
20            }
21        }
22        return maxLen;
23    }
24}
25