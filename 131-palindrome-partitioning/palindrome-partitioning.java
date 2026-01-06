class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ll=new ArrayList<>();
        List<String> list=new ArrayList<>();
        partition(s,list,ll);
        return ll;
    }
    public static void partition(String s,List<String>list,List<List<String>> ll){
        if(s.length()==0){
            ll.add(new ArrayList<String>(list));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String sp=s.substring(0,i);
            if(check(sp)){
                list.add(sp);
                partition(s.substring(i),list,ll);
                list.remove(list.size()-1);
            }
        }


    }
    public static boolean check(String s) {
		int i=0;
		int j=s.length()-1;
		while(i<=j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}