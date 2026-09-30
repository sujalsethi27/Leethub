class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : flights) {
            int f = edge[0];
            int t = edge[1];
            int cost = edge[2];
            list.get(f).add(new int[]{t, cost});
        }

        int[][] dist = new int[k + 2][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][src] = 0;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            int cost = current[0];
            int node = current[1];
            int stops = current[2];

            if (node == dst) {
                return cost;
            }

            if (stops < k + 1) {

          for (int[] edge : list.get(node)) {
                int adjnode = edge[0];
                int adjcost = edge[1];
                int newStops = stops + 1;
                int newCost = cost + adjcost;

                if (newCost < dist[newStops][adjnode]) {

                    dist[newStops][adjnode] = newCost;

                    pq.add(new int[]{
                            newCost,
                            adjnode,
                            newStops
                    });
                 }
              }           
           }
        }
        return -1;
    }
}
// here stops are counting flights taken