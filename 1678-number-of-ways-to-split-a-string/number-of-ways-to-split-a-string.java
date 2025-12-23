class Solution {
    int mod = 1000000007;

    public int numWays(String s) {
        int n = s.length();
        int  sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - '0';
        }
        if (sum % 3 != 0) return 0;

        sum = sum / 3;
        if (sum == 0) {
            return (int)(((long)(n - 2) * (n - 1) / 2) % mod);
        }

        int si = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            si += s.charAt(i) - '0';

            if (si == sum) c1++;
            if (si == 2 * sum) c2++;
        }

        return (int)(((long) c1 * c2) % mod);
    }
}
