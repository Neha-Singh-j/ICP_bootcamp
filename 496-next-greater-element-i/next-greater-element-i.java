class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int ans2[]=new int[nums1.length];
       return nextGreater(nums1,ans2,nums2);
    }
    private static int[] nextGreater(int[] nums1,int[] ans2,int[] nums2){
        Stack<Integer> st=new Stack<>();
        int ans[] =new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>=nums2[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=nums2[st.peek()];
            }
            st.add(i);
        }
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    ans2[i]=ans[j];
                }
            }
        }
        return ans2;
    }
}