class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         List<List<int[]>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
          list.add(new ArrayList<>());
        }
     for(int[] edge : times) {
         int u = edge[0];
         int v = edge[1];
         int wt = edge[2];
         list.get(u).add(new int[]{v, wt});
     }
     int[] dist = new int[n + 1];
     Arrays.fill(dist, Integer.MAX_VALUE);
     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
     dist[k] = 0;
     pq.add(new int[]{0, k});

       while (!pq.isEmpty()) {
          int[] current = pq.poll();
          int dis = current[0];
          int node = current[1];
         
         for(int[] edge : list.get(node)) {
         int adjnode = edge[0];
         int adjweight = edge[1];

        if(dist[node] != Integer.MAX_VALUE && dis + adjweight < dist[adjnode]) {
            dist[adjnode] = dis + adjweight;
         pq.add(new int[]{ dist[adjnode], adjnode});
          }
        }
       }
       int max = 0;
       for(int i = 1; i <= n; i++) {
        if(dist[i] == Integer.MAX_VALUE) {
          return -1;
        }
        max = Math.max(max, dist[i]);     
          }
          return max;
      }
    }