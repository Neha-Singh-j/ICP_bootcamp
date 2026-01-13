class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int[] ans=new int[n];
        ans[0]=ans[1]=1; //not prime
        for(int i=2;i*i<n;i++){ 
            if(ans[i]==0){ //check is it composite
                
                
                
                
                
                
                
                
                
                
                
                
                for(int j=2;j*i<n;j++){
                    ans[i*j]=1;
                }
            }
        }
        int c=0;
        for(int i:ans){
            if(i==0) c++;
        }
        return c;

    }
}