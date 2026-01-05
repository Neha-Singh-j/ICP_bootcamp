class Solution {
    HashMap<String, Integer> dp = new HashMap<>();
    public int longestStrChain(String[] words) {
        ArrayList<String> arr=new ArrayList<>();
        for(String s : words){
            arr.add(s);
        }
        int max=1;
        for(int i=0;i<arr.size();i++){
            max=Math.max(chain(arr,arr.get(i)),max);
        }
        return max;
    }
    public int chain(ArrayList<String> arr,String curr){
         if (dp.containsKey(curr)) {
            return dp.get(curr);
        }
        int max=1;
        for(int j=0;j<curr.length();j++){
            String s=curr.substring(0,j)+curr.substring(j+1);
            if(arr.contains(s)){
                max=Math.max(chain(arr,s)+1,max);
            }
        }
        dp.put(curr, max);
         return max;
    }
}