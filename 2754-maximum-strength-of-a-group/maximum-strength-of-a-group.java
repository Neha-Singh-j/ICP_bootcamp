class Solution {
    public long maxStrength(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> arr=new ArrayList<>();
        if(n==1) return nums[0]; //base case
        Arrays.sort(nums);
        long mul=1;
        int z=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                mul*=nums[i];
            if(nums[i]==0) z++;
            if(nums[i]<0){
                arr.add(nums[i]);
            }
        }
        // if(there is no +ve number but 0 is ther0 e)
         if(arr.size()<2 && z>0 && mul==1 && n-(arr.size()+z)==0) return 0;
         // if  no +Ve number and 0 is there and -ve is 1 only
        if(arr.size()==1 && n==1) return nums[0];
        Collections.sort(arr);
        boolean flag=false;
        if(arr.size()%2==0) flag=true;
        for(int i=0;i<arr.size();i++){
                if(i==arr.size()-1 && flag==false){
                    break;
                }
                mul*=arr.get(i);
        }
        
        return mul;

    }
}