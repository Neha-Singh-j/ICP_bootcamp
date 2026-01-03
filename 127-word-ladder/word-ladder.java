class Solution {
    HashMap<String, List<String>> map;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        map = new HashMap<>();

        for (String w : wordList) {
            map.put(w, new ArrayList<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isConnected(wordList.get(i), wordList.get(j))) {
                    map.get(wordList.get(i)).add(wordList.get(j));
                    map.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

        // add beginWord
        if (!map.containsKey(beginWord)) {
            map.put(beginWord, new ArrayList<>());
            for (String w : wordList) {
                if (isConnected(beginWord, w)) {
                    map.get(beginWord).add(w);
                    map.get(w).add(beginWord);
                }
            }
        }

        return bfs(beginWord, endWord);
    }

    public int bfs(String src, String des) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        q.add(src);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String r = q.poll();

                if (visited.contains(r)) continue;
                visited.add(r);

                if (r.equals(des)) return level;

                for (String nbr : map.get(r)) {
                    if (!visited.contains(nbr)) {
                        q.add(nbr);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private boolean isConnected(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
