class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1=0;
        int xor2=0;
        for(int a: arr1) xor1^=a;
        for(int a: arr2) xor2^=a;
        return xor1&xor2;

    }
}