class Solution {
    public boolean canReach(int[] arr, int start) {
        return reach(arr,start);
    }
    public boolean reach(int[]arr, int i){
        if(i<0 || i>=arr.length) return false;
        if(arr[i]==0) return true;
        //mark visited otherwise recursion will not end
        if (arr[i] < 0) return false;   // already visited

        int jump = arr[i];
        arr[i] = -arr[i]; 
        boolean a=reach(arr,i+jump);
        boolean b=reach(arr,i-jump);
        return a||b;
    }
}