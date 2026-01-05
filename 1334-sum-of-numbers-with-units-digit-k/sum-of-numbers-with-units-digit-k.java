class Solution {
    public int minimumNumbers(int num, int k) {
        if(num==0) return 0;
        for(int i=1;i<=10;i++){
            int sum=i*k;
            if(sum<=num && sum%10==num%10) return i;
        }
        return -1;
    }
}