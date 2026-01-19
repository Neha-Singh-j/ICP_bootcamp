class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1=new StringBuilder();
        StringBuilder t1=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#'){
            s1.append(s.charAt(i));
            }
            if(s.charAt(i)=='#'&& s1.length()>0){
               s1.deleteCharAt(s1.length()-1);
            }
        }
         for(int i=0;i<t.length();i++){
             if(t.charAt(i)!='#'){
            t1.append(t.charAt(i));
            }
           
            if(t.charAt(i)=='#'&& t1.length()>0){
               t1.deleteCharAt(t1.length()-1);
            }
        }
        return s1.toString().equals(t1.toString());
    }
}