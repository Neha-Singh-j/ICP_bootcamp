class Solution {
    public int minimizeXor(int num1, int num2) {
        
        return x_find(num1,num2);
    }
    public static int x_find(int nums1 , int nums2){
        int set_bit=0;
        while(nums2>0){
            nums2=(nums2&(nums2-1));
            set_bit++;
        }
        int x=0;
        for(int i=30;i>=0;i--){
            int  mask=(1<<i);
            if((nums1 & mask)!=0){
                x|=mask; //x=x|mask;
                set_bit--;
            if(set_bit==0) return x;
            }
        }
        for(int i=0;i<=30;i++){
             int  mask=(1<<i);
            if((nums1 & mask)==0){
                x|=mask; //x=x|mask;
                set_bit--;
            if(set_bit==0) return x;
            }
        }
        return x;
    }
}