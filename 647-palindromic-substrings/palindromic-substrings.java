class Solution {
    public int countSubstrings(String s) {
        return count(s);
    }

    public int count(String s){
        // odd length
        int odd=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;i-j>=0 && i+j<s.length();j++){
                if(s.charAt(i-j)!=s.charAt(i+j)) break;
                odd++;
            }
        }
        // even
        int even=0;
        for(double i=0.5;i<s.length();i++){
            for(double j=0.5;i-j>=0 && i+j<s.length();j++){
                if(s.charAt((int)(i-j))!=s.charAt((int)(i+j))) break;
                even++;
            }
        }
        return odd+even;
    }
}