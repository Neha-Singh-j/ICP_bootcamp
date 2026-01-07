// Last updated: 1/7/2026, 10:00:27 PM
1class Solution {
2    public List<String> getLongestSubsequence(String[] words, int[] groups) {
3        List<String> arr=new ArrayList<>();
4        arr.add(words[0]);
5        int curr=groups[0];
6        for(int i=1;i<groups.length;i++){
7            if(groups[i]!=curr){
8                arr.add(words[i]);
9                curr=groups[i];
10            }
11        }
12        return arr;
13    }
14}