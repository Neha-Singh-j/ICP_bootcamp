class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] diff=new int[nums1.length];
          int max = 0;
        for(int i=0;i<nums1.length;i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
            max=Math.max(max, diff[i]);
        }
        long k=(long) k1+k2;
        Arrays.sort(diff);
        long[] freq = new long[max + 1];
        for (int d : diff) freq[d]++;
        for (int d = max; d > 0 && k > 0; d--) {
            if (freq[d] == 0) continue;
            long take = Math.min(freq[d], k);
            freq[d] -= take;
            freq[d - 1] += take;
            k -= take;
        }
        long sum=0;
        for (int d = 0; d <= max; d++) {
            sum += freq[d] * (long) d * d;
        }
        return sum;
    }
}