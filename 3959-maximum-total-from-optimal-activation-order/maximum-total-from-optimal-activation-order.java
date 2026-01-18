class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n = limit.length;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][1] = value[i];
            arr[i][0] = limit[i];
        }

        Arrays.sort(arr, (a, b) ->{
            if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
            return Integer.compare(a[0],b[0]);
        }); 
        int j=0;
        long total=0;
        for (int i = 0; i < n;) {
           
            total += arr[i][1];
            i++;
            int active=i-j;
            while(j<n && arr[j][0]<=active){
                j++;
            }
            while(j>i){
                i++;
            }
        }

        return total;
    }
}
