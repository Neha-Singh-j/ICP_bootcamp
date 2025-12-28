class Solution {
    public class Pair{
        char ch;
        int freq;
        public Pair(char ch, int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    public String minimizeStringValue(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int c=0;
        for(char ch: s.toCharArray()){
            if(ch=='?') c++;
            else map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>( 
            (a, b) -> a.freq == b.freq ? a.ch - b.ch : a.freq - b.freq);
           //adding all characters that one also that is not present bcz help in getting minimum fre chars lexicographically
        for (char ch = 'a'; ch <= 'z'; ch++) {
            pq.add(new Pair(ch, map.getOrDefault(ch, 0)));
        }
        //this condition handling null pointer exception as "???" then pq is empty
        if (pq.isEmpty()) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                pq.add(new Pair(ch, 0));
            }
        }
        StringBuilder sb=new StringBuilder();
        char[] arr=new char[c];
        int i=0;
        while(i!=c){
            Pair p=pq.poll();
            arr[i]=p.ch;
            p.freq++; //bcz we used this one more time so its cost inc by 1
            pq.add(p);
            i++;
        }
        Arrays.sort(arr);
        i=0;
        for(char curr:s.toCharArray()){
            if(curr!='?'){
                sb.append(curr);
            }
            else{
                sb.append(arr[i]);
                i++;
            }
        }
        return sb.toString();
    }
}