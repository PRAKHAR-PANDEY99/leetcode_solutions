import java.util.*;

class Solution {

    List<List<String>> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    String beginWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        this.beginWord = beginWord;

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return ans;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        map.put(beginWord, 1);
        set.remove(beginWord);

        while (!q.isEmpty()) {

            String word = q.poll();
            int steps = map.get(word);

            if (word.equals(endWord))
                break;

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;
                    String next = new String(arr);

                    if (set.contains(next)) {
                        q.offer(next);
                        set.remove(next);
                        map.put(next, steps + 1);
                    }
                }

                arr[i] = original;
            }
        }

        if (map.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, path);
        }

        return ans;
    }

    void dfs(String word, List<String> path) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        int steps = map.get(word);
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            char original = arr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {

                arr[i] = ch;
                String prev = new String(arr);

                if (map.containsKey(prev) && map.get(prev) + 1 == steps) {
                    path.add(prev);
                    dfs(prev, path);
                    path.remove(path.size() - 1);
                }
            }

            arr[i] = original;
        }
    }
}