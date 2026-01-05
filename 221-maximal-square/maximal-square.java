class Solution {
    public int maximalSquare(char[][] matrix) {
       int[] arr=new int[matrix[0].length];
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    arr[j]=0;
                }else{
                    arr[j]++;
                }
            }
            ans=Math.max(ans,Largest_hist(arr));
        }
        return ans;
    }
    public static int Largest_hist(int[] arr) {
		Stack<Integer> st=new Stack<>();
		int ans=0;
		for(int i=0;i<arr.length;i++) {
			while(!st.isEmpty() && arr[i]<arr[st.peek()]) {
				int h = arr[st.pop()];
                int r = i;
                int l = st.isEmpty() ? -1 : st.peek();

                int width = r - l - 1;
                int side = Math.min(h, width);

                ans = Math.max(ans, side * side);
			}
				
			st.push(i);
		}
		int r=arr.length;
		 while (!st.isEmpty()) {
            int h = arr[st.pop()];
            int l = st.isEmpty() ? -1 : st.peek();

            int width = r - l - 1;
            int side = Math.min(h, width);

            ans = Math.max(ans, side * side);
        
		}
		return ans;
	}

}