class Solution {
    public String generateTag(String caption) {
        StringBuilder sb=new StringBuilder();
        //base cases and required conditions 
        caption = caption.trim();
        sb.append("#");
        if(caption.length()<=0) return "#";

        sb.append(Character.toLowerCase(caption.charAt(0)));

        for(int i=1;i<caption.length();i++){

            if(caption.charAt(i)==' ') continue;

            if(Character.isLetter(caption.charAt(i))){
                if(caption.charAt(i-1)==' ')
                    sb.append(Character.toUpperCase(caption.charAt(i)));
                else
                    sb.append(Character.toLowerCase(caption.charAt(i)));
            }
        }
        //truncate
        if (sb.length() > 100) {
            return sb.substring(0, 100);
        }
        String res=sb.toString();
        return res;
    }
}