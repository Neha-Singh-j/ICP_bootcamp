class Solution {
    public String smallestString(String s) {
        //replacing for all except 'a' so we have to find substring that is left most and not containg 'a' update that its become smallest 
        //constion---> if all are 'a' then we cant leave it as it is as per question atleast one change requiresd so we update last char 'z' to 'z'
        char[] str=s.toCharArray();
        int n=str.length;
        int i=0;
        for(;i<n;i++){
            if(str[i]!='a') break;
        }
        //case all char are 'a'
        if(i==n){
            str[n-1]='z';
            return new String(str);
        } 
        for (; i < n && str[i] != 'a'; i++) {
            str[i] = (char)(str[i] - 1);
        }
        return new String(str); 
    }
}