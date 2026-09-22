class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

      List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
        list.add(new ArrayList<>());
       }

    for (int i = 0; i < prerequisites.length; i++) {
    int course = prerequisites[i][0];
    int prerequisite = prerequisites[i][1];
    list.get(prerequisite).add(course);
}
      int[] indegree = new int[numCourses];
      for(int i = 0; i < numCourses; i++) {
       for(int neighbour : list.get(i)) {
            indegree[neighbour]++;
           }
      } 
      Queue<Integer> q = new LinkedList<>();
      for(int i = 0; i < numCourses; i++) {
        if(indegree[i] == 0) {
            q.add(i);
        }
      }
      List<Integer> anslist = new ArrayList<>();
      int count = 0;
      while(!q.isEmpty()) {
        int node = q.poll();
        anslist.add(node);
        count++;

          for(int neighbour : list.get(node)) {
          indegree[neighbour]--;
          if(indegree[neighbour] == 0) {
            q.add(neighbour);
          }
          }
      }
      int[] ans = new int[anslist.size()];
     for(int i = 0; i < anslist.size(); i++) {
     ans[i] = anslist.get(i);
 }
  if(count == numCourses) {
    return ans;
  } else {
    return new int[0];
  }
    }
}