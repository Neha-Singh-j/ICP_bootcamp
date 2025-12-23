class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        String min = s1;
        if (len2 < min.length()) min = s2;
        if (len3 < min.length()) min = s3;

        while (min.length() > 0) {
            if (s1.startsWith(min) && s2.startsWith(min) && s3.startsWith(min)) {
                return (len1 + len2 + len3) - 3 * min.length();
            } else {
                min = min.substring(0, min.length() - 1);
            }
        }

        return -1;
    }
}
