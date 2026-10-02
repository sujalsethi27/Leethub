class Solution {
    public int countPaths(int n, int[][] roads) {
      List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int time = road[2];
            graph.get(from).add(new int[]{to, time});
            graph.get(to).add(new int[]{from, time});
        }

     long[] dist = new long[n];
     Arrays.fill(dist, Long.MAX_VALUE);
      dist[0] = 0;
         PriorityQueue<long[]> pq =
    new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});
        long[] ways = new long[n];
        ways[0] = 1;
        // source wle ko ways 1 rkhte hai kyuki atleast 1 way to hoga hi

        while(!pq.isEmpty()) {
         long[] current = pq.poll();
        long timetaken = current[0];
         int city = (int) current[1];

        if (timetaken > dist[city]) {
          continue;
         }
         // this if condtion means if current time taken is more than previous then just skip it dont process it. it is stale. It is just to save the time by not processign the stale nodes

         for(int[] road : graph.get(city)) {
            int nextcity = road[0];
          long newtime = timetaken + road[1];
           if (newtime < dist[nextcity]) {
          dist[nextcity] = newtime;
          ways[nextcity] = ways[city];
             // Jab naya shortest distance milta hai, nextcity ke purane ways discard karke ways[city] copy karte hain
        pq.add(new long[]{newtime, nextcity});
     }
       else if (newtime == dist[nextcity]) {
     ways[nextcity] = (ways[nextcity] + ways[city]) % 1000000007;     
// agr time same hai to fir ways + 1 hote rhenge as hume same time me ek aur way mil gya hai
      }
         }
        }
return (int) ways[n - 1];
    }
}