class Solution {
    public int largestPrime(int n) {
        int[] prime=prime(n+1);
        int ans=0;
        int sum=0;
        for(int i=0;i<=n;i++){
            if(prime[i]==0)
                sum+=i;
            if(sum>n) break;
            if(prime[sum]==0){
                ans=sum;
            }
        }
        return ans;
    }
    public int[] prime( int n) {
        int[] ans=new int[n];
        ans[0]=ans[1]=1; //not prime
        for(int i=2;i*i<n;i++){ 
            if(ans[i]==0){ //check is it composite
                for(int j=2;j*i<n;j++){
                    ans[i*j]=1;
                }
            }
        }
        return ans;
    }
}