class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        //nums1[i] occurs no of times second array elength if nums2 len is even then nums1[i] not contributing to result
        int x=0;
        int n1=nums1.length;
        int n2=nums2.length;
        //if one is odd len one is even then take xor of odd len only
        //if both array of odd even len then xor=0;
        //if both are odd tehn both contribute
    
        if(n2%2!=0){ //if array 2 is
            for(int i=0;i<nums1.length;i++){
                x^=nums1[i];
            }
        }
        if(n1%2!=0){
            for(int i=0;i<nums2.length;i++){
                x^=nums2[i];
            }
        }
        return x;
    }
}