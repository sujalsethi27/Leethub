class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int n = graph.length;
       int[] outdegree = new int[n];

       List<List<Integer>> reverseGraph = new ArrayList<>();
       for (int i = 0; i < n; i++) {
       reverseGraph.add(new ArrayList<>());
       }
       for(int i = 0; i < n; i++) {
        for(int neigh : graph[i]) {
            reverseGraph.get(neigh).add(i);
            outdegree[i]++;
        }
       }
       Queue<Integer> q = new LinkedList<>();
       for(int i = 0; i < n; i++) {
        if(outdegree[i] == 0) {
            q.add(i);
        }
       }
       List<Integer> anslist = new ArrayList<>();
       while(!q.isEmpty()) {
        int node = q.poll();
        anslist.add(node);

          for (int neigh : reverseGraph.get(node)) {
          outdegree[neigh]--;
          if(outdegree[neigh] == 0) {
           q.add(neigh);
          }
          }
       }
       Collections.sort(anslist);
      return anslist;
    } 
}