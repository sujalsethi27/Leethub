class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int price = edge[2];
            graph.get(from).add(new int[]{to, price});
            graph.get(to).add(new int[]{from, price});
        }

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
        Arrays.fill(dist[i], Integer.MAX_VALUE); // ye n rows tk jyega and hr row ke i ko check krega iskie dist[i]
        for (int[] edge : edges) {
    int from = edge[0];
    int to = edge[1];
    int price = edge[2];
    dist[from][to] = price;
    dist[to][from] = price;
}
        dist[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
        if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
          }
       }
    }
    int result = 0;
    int mincount = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++) {
     int count = 0; // here we write the count below the outer loop as we want to calculate for each city thats why it calculates the max for each city and then set to zero for the nex city onwards
      for(int j = 0; j < n; j++) {
     if(i != j && dist[i][j] <= distanceThreshold) {
        count++;  
     }
         }
         // here we write the min count block inside the outer loop as we compare for each city and the city with the min count will we set as the result
        if(count <= mincount) {
        mincount = count;
        result = i;
     }
      }
      return result;
   }
}
// by floydd method..we use 3 nested loop for floydd and then check by 2 more nested loops