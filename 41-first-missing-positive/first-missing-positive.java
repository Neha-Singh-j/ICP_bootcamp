class Solution {
   public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(nums[i]>0){ //we have to find first posiitve 
                set.add(nums[i]);
            }
        }
        int i=1;
        while(true){
            if(!set.contains(i)) return i;
            i++;
        }
    }
}