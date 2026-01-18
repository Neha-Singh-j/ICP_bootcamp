class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0 || nums[i]>n) nums[i]=n+1;
        }

        for(int i=0;i<n;i++){
                int val=Math.abs(nums[i]);
                if(val>0 && val<=n){ // to prevent out of bound conditon 
                 int idx=val-1; //idx 0 based
                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx]; 
                }
             }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){ //the missing one only havennot -ve value 
                return i+1;
            }
        }
        return n+1;
    }
}