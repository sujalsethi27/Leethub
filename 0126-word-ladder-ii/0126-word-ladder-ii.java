class Solution {

    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> parent = new HashMap<>();
    Map<String, Integer> level = new HashMap<>();

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return ans;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        level.put(beginWord, 0);

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            for (int j = 0; j < size; j++) {

                String word = q.poll();
                int currentLevel = level.get(word);

                for (int i = 0; i < word.length(); i++) {

                    char[] chars = word.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (chars[i] == ch) {
                            continue;
                        }

                        chars[i] = ch;

                        String newWord = new String(chars);

                        if (!set.contains(newWord)) {
                            continue;
                        }

                        // First time we found this word
                        if (!level.containsKey(newWord)) {

                            level.put(newWord, currentLevel + 1);

                            parent.put(
                                newWord,
                                new ArrayList<>()
                            );

                            parent.get(newWord).add(word);

                            q.add(newWord);

                        }

                        // Found through another shortest path
                        else if (level.get(newWord) == currentLevel + 1) {

                            parent.get(newWord).add(word);
                        }

                        if (newWord.equals(endWord)) {
                            found = true;
                        }
                    }
                }
            }
        }

        // Backtracking from endWord → beginWord
        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, path);

        return ans;
    }


    private void dfs(
            String word,
            String beginWord,
            List<String> path) {

        if (word.equals(beginWord)) {

            List<String> result = new ArrayList<>(path);

            Collections.reverse(result);

            ans.add(result);

            return;
        }

        if (!parent.containsKey(word)) {
            return;
        }

        for (String p : parent.get(word)) {

            path.add(p);

            dfs(p, beginWord, path);

            path.remove(path.size() - 1);
        }
    }
}