class Solution {
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
       return rec(nums,target,0,0);
    }
    public int rec(int[] arr, int t, int i, int curr){
        if(i==arr.length){
            if(curr==t){
                return 1;
            }
            return 0;
        }
        int s1=rec(arr,t,i+1,curr+arr[i]);
        int s2=rec(arr,t,i+1,curr-arr[i]);
        return s1+s2;

    }
}