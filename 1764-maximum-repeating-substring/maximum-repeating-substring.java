class Solution {
    public int maxRepeating(String sequence, String word) {
       int n=word.length();
       int m=sequence.length();
       int c=0;
        StringBuilder sb=new StringBuilder();
        sb.append(word);
       while(sequence.contains(sb)){
        sb=sb.append(word);
        c++;
       }
       return c;
    }
}