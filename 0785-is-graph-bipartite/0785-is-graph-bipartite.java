class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);  
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.length; i++) {
         if(color[i] == -1) {
            color[i] = 0;
            q.add(i);
         }
          while(!q.isEmpty()) {
            int node = q.poll();
         for (int neighbour : graph[node]) {
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
// we have to write while loop under the for loop as if the for loop completes first then all the elements becomes zero which means we cannot proof bipartite as all are same color so process one node and check its neighbour firsst