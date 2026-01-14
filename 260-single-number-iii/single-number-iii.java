class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans=new int[nums.length];
        int curr=0;
        for(int i=0;i<nums.length;i++){
            curr^=nums[i];
        }
        // curr is now xor of two unique numbers
        int mask=(curr&(-1*curr)); 
        //int mask= curr^&(curr-1)
        int a=0;
        for(int i=0;i<nums.length;i++){
            if((mask & nums[i])!=0){
                a=a^nums[i];
            }
        }
        int b= curr^a;
        return new int[] {a,b};
    }
}