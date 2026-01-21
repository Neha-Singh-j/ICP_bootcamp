class Solution {
    public boolean doesValidArrayExist(int[] arr) {
        int ans=0;
        for(int a:arr){
            ans^=a;
        }
        return ans==0;
        
    }
}