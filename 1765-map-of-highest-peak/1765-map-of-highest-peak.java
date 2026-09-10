class Solution {
    public int[][] highestPeak(int[][] isWater) {
 int[][] dist = new int[isWater.length][isWater[0].length];
        int n = isWater.length;
        int m = isWater[0].length; 
    Queue<Pair> q = new LinkedList<>();
    boolean[][] vis = new boolean[n][m]; 
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(isWater[i][j] == 1 && !vis[i][j]) {
                 vis[i][j] = true;
                dist[i][j] = 0;
            q.add(new Pair(i, j));
            }
       }
     }  
      while(!q.isEmpty()) {
        Pair p = q.poll();
        int row = p.row;
        int col = p.col;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};  
        for(int k = 0; k < 4; k++) {
        int newrow = row + dr[k];
        int newcol = col + dc[k];   
        if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && isWater[newrow][newcol] == 0 && !vis[newrow][newcol]) {
     vis[newrow][newcol] = true;
    dist[newrow][newcol] = dist[row][col] + 1;
    q.add(new Pair(newrow, newcol));
        } 
        }
         }
     return dist;    
   }
 }

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}