class Solution {
    int mod=1000000007;
    public int countNicePairs(int[] nums) {
        long count = 0;
        int n=nums.length;
        //nums[i]+rev(nums[j])=nums[j]+rev(nums[i]) this is equilvaent to 
        //nums[i]-rev(nums[i]) this gives you diffrenece that easy to handle and count in one loop
        HashMap<Integer,Long> map=new HashMap<>();
        for(int i=0;i<n;i++){
                int diff=nums[i]-rev(nums[i]); 
                count = (count + map.getOrDefault(diff, 0L)) % mod; //if same diff avsailabel bedore just add to res 
                map.put(diff,map.getOrDefault(diff,0L)+1);
        }
        return (int) count;
    }
    private int rev(int num){
        int n=0;
        while(num>0){
            int rem=num%10;
            n=n*10+rem;
            num/=10;
        }
    return n;
    }
    
}