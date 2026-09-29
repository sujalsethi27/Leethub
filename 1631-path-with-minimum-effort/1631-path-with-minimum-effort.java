class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
     int[][] dist = new int[n][m];
     for (int[] row : dist) {
    Arrays.fill(row, Integer.MAX_VALUE);
    }
     dist[0][0] = 0;
 PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    int row = 0;
    int col = 0;
    int effort = 0;
    pq.add(new int[]{effort, row, col});

    
       while (!pq.isEmpty()) {
          int[] current = pq.poll();
           effort = current[0];
           row = current[1];
           col = current[2];
           if (row == n - 1 && col == m - 1) {
             return effort;
           }
           int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};  
            for(int k = 0; k < 4; k++) {
            int newrow = row + dr[k];
            int newcol = col + dc[k];
            if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m) {
            int diff = Math.abs(heights[row][col] - heights[newrow][newcol]);
            int neweffort = Math.max(effort, diff);
            if (neweffort < dist[newrow][newcol]) {
              dist[newrow][newcol] = neweffort;
           pq.add(new int[]{neweffort, newrow, newcol});
            }
            }
          }
       }
       return effort;
    }
}