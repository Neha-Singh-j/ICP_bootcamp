class Solution {
    public int jump(int[] nums) {
        int maxJump=0;
        int c=0;
        int endJump=0;
        for(int i=0;i<nums.length-1;i++){
            maxJump=Math.max(maxJump,nums[i]+i);
            if(i==endJump){
                c++;
                endJump=maxJump;
            }
        }
        return c;

    }
}  
//         int n=nums.length;
//         int near=0,far=0,jump=0;
//         while(far<n-1){
//             int farthest=0;
//             for(int i=near;i<=far;i++){
//                 farthest=Math.max(farthest,i+nums[i]);
//             }
//             near=far+1;
//             far=farthest;
//             jump++;
//         }
//         return jump;
//     }
// }