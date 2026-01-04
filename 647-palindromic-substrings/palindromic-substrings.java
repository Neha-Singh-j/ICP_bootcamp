class Solution {
    public int countSubstrings(String s) {
        int c=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(pal(s.substring(i,j+1))) c++;
            }
        }
        return c;
    }
    public static boolean pal(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
                i++;
                j--;
            
        }
        return true;
    }
    public  int Count_Palindromic(String s) {
		int odd = 0;
		// odd
		for (int axis = 0; axis < s.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
				if (s.charAt(axis - orbit) != s.charAt(axis + orbit)) {
					break;
				}
				odd++;
				System.out.println(s.substring(orbit,axis));
			}
		}
		// even
		int even=0;
		for (double axis = 0.5; axis < s.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
				if (s.charAt((int) (axis - orbit)) != s.charAt((int) (axis + orbit))) {
					break;
				}
				even++;
				int c=(int)(axis);
				System.out.println(s.substring((int)orbit,c));
			}
		}
		return odd+even;

	}
}