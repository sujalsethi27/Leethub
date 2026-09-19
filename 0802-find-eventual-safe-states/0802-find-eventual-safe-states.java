class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        int[] pathvis = new int[graph.length];
        int[] check = new int[graph.length];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < graph.length; i++) {
          if(vis[i] == 0) {
             dfsCheck(i, graph, vis, pathvis, check);
            }
        }
         for(int i = 0; i < graph.length; i++) {
            if(check[i] == 1) {
                list.add(i);
            }
         }
         return list;
    }
    
    public boolean dfsCheck(int node, int[][] graph, int[] vis, int[] pathvis, int[] check) {
           vis[node] = 1;
          pathvis[node] = 1;
          check[node] = 0;
      for(int neighbour : graph[node]) {
        // list.get give us the values store in that node of arraylist
        if(vis[neighbour] == 0) {
            if(dfsCheck(neighbour, graph, vis, pathvis, check) == true) {
                check[node] = 0;
                return true;
            }
        }
        else if(pathvis[neighbour] == 1) {
            check[node] = 0;
            return true;
        }
      }
      check[node] = 1;
   pathvis[node] = 0;
   return false;
    } 
}