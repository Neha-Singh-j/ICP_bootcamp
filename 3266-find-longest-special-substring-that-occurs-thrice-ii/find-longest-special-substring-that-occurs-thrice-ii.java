class Solution {
    public int maximumLength(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            int currp = 1;
            char ch = s.charAt(i);
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                currp ++;
                i ++;
            }
            map.computeIfAbsent(ch, k -> new ArrayList<>()).add(currp);
            i ++;
        }

        int maxi = -1;
        for (List<Integer> lis : map.values()) {
            lis.sort(Collections.reverseOrder());
            
            if (lis.get(0) >= 3) {
                maxi = Math.max(maxi, lis.get(0) - 2);
            }
            
            if (lis.size() >= 2) {
                if (lis.get(0) >= 2) {
                    maxi = Math.max(maxi, Math.min(lis.get(0) - 1, lis.get(1)));
                }
                if (lis.size() >= 3) {
                    maxi = Math.max(maxi, Math.min(lis.get(0), Math.min(lis.get(1), lis.get(2))));
                }
            }
        }

        return maxi;
    }
}