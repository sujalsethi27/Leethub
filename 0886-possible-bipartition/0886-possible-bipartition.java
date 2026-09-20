class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
            for(int j = 0; j < dislikes.length; j++) {
                int m = dislikes[j][0];
                int o = dislikes[j][1];
                graph.get(m).add(o);
                graph.get(o).add(m);

        }
        int[] color = new int[graph.size()];
        Arrays.fill(color, -1);  
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < n + 1; i++) {
         if(color[i] == -1) {
            color[i] = 0;
            q.add(i);
         }
          while(!q.isEmpty()) {
            int node = q.poll();
         for (int neighbour : graph.get(node)) {
            if (color[neighbour] == -1) {
            color[neighbour] = 1 - color[node];
            q.add(neighbour);
            }
        else if(color[node] == color[neighbour]) {
            return false;
          }
          }
        }
        }
        return true;
    }
}