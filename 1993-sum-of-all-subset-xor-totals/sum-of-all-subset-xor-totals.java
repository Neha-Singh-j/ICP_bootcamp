class Solution {
    public int subsetXORSum(int[] nums) {
        int n=nums.length;
        int total = 0;
        for (int num : nums) {
            total |= num; 
        }
        //total 2^n subsets--> 2^(n-1) are odd and same are even even xor get 0 and odds xor get to 1 
        return total*(int)Math.pow(2,n-1);
    }
}