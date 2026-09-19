class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] vis = new int[numCourses];
        int[] pathvis = new int[numCourses];

      List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
        list.add(new ArrayList<>());
        // here we make arraylist for each of the course like
        // 0 -> []
        // 1 -> []
       }

    for (int i = 0; i < prerequisites.length; i++) {
    int course = prerequisites[i][0];
    int prerequisite = prerequisites[i][1];
    list.get(prerequisite).add(course);
    // here we take the bi and add the ai to the list like
    // 0 -> [1]
}
        for(int i = 0; i < numCourses; i++) {
            if(vis[i] == 0) {
       if(dfsCheck(i, list, vis, pathvis) == true) {
           return false;
       }
            }
        }
        return true;
    }
   public boolean dfsCheck(int node, List<List<Integer>> list , int[] vis, int[] pathvis) {
      vis[node] = 1;
      pathvis[node] = 1;

      for(int neighbour : list.get(node)) {
        // list.get give us the values store in that node of arraylist
        if(vis[neighbour] == 0) {
            if(dfsCheck(neighbour, list, vis, pathvis) == true) {
                return true;
            }
        }
        else if(pathvis[neighbour] == 1) {
            return true;
        }
      }
   pathvis[node] = 0;
   return false;
   }
}