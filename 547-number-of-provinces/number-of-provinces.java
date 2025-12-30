class Solution {
    public int findCircleNum(int[][] isConnected) {
        //make adjancy list using hashmap
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int n= isConnected.length;
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j)
                    map.get(i).add(j);
            }
        }
        return Components(map);  //BFT code for counting components
    }
    public static int Components(HashMap<Integer,List<Integer>> map){
         Queue<Integer> q=new LinkedList<>();
		HashSet<Integer> visited=new HashSet<>();
		int c=0;
		for(int src: map.keySet()) {
			if(visited.contains(src)) { 
				continue;
			}
			c++;
			q.add(src);
			while(!q.isEmpty()) {
	//			1.remove
				int r=q.poll();
	//			2.Ignore if ALready visited
				if(visited.contains(r)) {
					continue;
				}
	//			3.mark visited
				visited.add(r);
//	//			4.self work
//				System.out.print(r+" ");
	//			5.add unvisited nbrs
				for(int nbrs:map.get(r)) {
					if(!visited.contains(nbrs)) {
						q.add(nbrs);
					}
				}
			}
		}
		return c; 
	}
}