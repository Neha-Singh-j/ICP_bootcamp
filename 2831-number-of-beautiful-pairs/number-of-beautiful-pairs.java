class Solution {
    public int countBeautifulPairs(int[] nums) {
        String[] arr=new String[nums.length];
            for(int i=0;i<nums.length;i++){
                arr[i]=String.valueOf(nums[i]);
            }
            int c=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int first=arr[i].charAt(0)-'0';
                  int last = nums[j] % 10; 
                if(coprime(first,last)) c++;
            }
        }
        return c;
    }
    public static boolean coprime(int a,int b){
        return gcd(a,b)==1;
    }
    public static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;

        }
        return a;
    }
}