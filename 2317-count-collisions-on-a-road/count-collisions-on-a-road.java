class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int lft = 0, rght = n - 1;
        // Ignore leading L
        while (lft < n && directions.charAt(lft) == 'L') {
            lft++;
        }
        // Ignore trailing R
        while (rght >= 0 && directions.charAt(rght) == 'R') {
            rght--;
        }
        int ans = 0;
        //every collison get +2 when both are moving else if 's' is one then moving one coliision get count so only moving collisions get counted;
        for (int i = lft; i <= rght; i++) {
            if (directions.charAt(i) != 'S') {
                ans++;
            }
        }
        return ans;
    }
}