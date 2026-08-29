class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<Integer> list = new ArrayList<>();
        int V = isConnected.length;
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
          for(int i = 0; i < V; i++) {
                if(vis[i] == false) {
                    count++;
                    vis[i] = true;
                    q.add(i);
                }
        while(!q.isEmpty()) {
            Integer node = q.poll();
            list.add(node);

            for(int j = 0; j < V; j++) {
             if (isConnected[node][j] == 1 && !vis[j]) {
                 vis[j] = true;
                 q.add(j);
                 }
            }
        }
        }
        return count;
    }
}