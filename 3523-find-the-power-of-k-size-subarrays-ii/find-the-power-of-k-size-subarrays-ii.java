class Solution {
    public int[] resultsArray(int[] nums, int k) {

        int n=nums.length;
        int[] res=new int[n-k+1];
        int c=0; // counting all bad(that cause arr unsorted or non conscutive) in current window
        for(int j=1;j<k;j++){
            if(nums[j]-nums[j-1]!=1) c++;
        }
        if(c==0) res[0]=nums[k-1];
        else res[0]=-1;
        int i=1;
        int st=0;
        int end=k;
        while(end<n){
            
            if(nums[st+1]-nums[st]!=1) c--; //one bad element get removed from subarray
            if(nums[end]-nums[end-1]!=1) c++;
            st++;
            if(c==0){
                res[i]=nums[end];
            }else{
                res[i]=-1;
            }
            end++;
            i++;
        }
        return res;
    }
    public static boolean check(ArrayList<Integer> arr){
        for(int i=1;i<arr.size();i++){
            if(arr.get(i)<=arr.get(i-1) || arr.get(i)-arr.get(i-1)!=1) return false;
        }
        return true;
    }
}