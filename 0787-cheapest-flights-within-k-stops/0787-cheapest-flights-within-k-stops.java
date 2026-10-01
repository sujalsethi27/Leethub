class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Graph
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {

            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.get(from).add(new int[]{to, price});
        }

        // dist[flightsTaken][city]
        int[][] dist = new int[k + 2][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Source par 0 flights li hain
        dist[0][src] = 0;

        // {cost, city, flightsTaken}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, src, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int cost = current[0];
            int city = current[1];
            int flightsTaken = current[2];

            // Destination mil gaya
            if (city == dst) {
                return cost;
            }

            // Maximum allowed flights already use ho chuki hain
            if (flightsTaken == k + 1) {
                continue;
            }

            // Current city se next flights
            for (int[] flight : graph.get(city)) {

                int nextCity = flight[0];
                int flightPrice = flight[1];

                int newFlightsTaken = flightsTaken + 1;
                int newCost = cost + flightPrice;

                // Same number of flights mein cheaper route mila?
                if (newCost < dist[newFlightsTaken][nextCity]) {

                    dist[newFlightsTaken][nextCity] = newCost;

                    pq.add(new int[]{
                            newCost,
                            nextCity,
                            newFlightsTaken
                    });
                }
            }
        }

        return -1;
    }
}