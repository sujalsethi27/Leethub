class Solution {
    public int orangesRotting(int[][] grid) {
      Queue<Pair> q = new LinkedList<>(); 
      int n = grid.length;
      int m = grid[0].length;
      int minute = 0; 
      int fresh = 0;
   for(int i = 0; i < n; i++) {
    for(int j = 0; j < m; j++) {
        if(grid[i][j] == 2) {
            q.add(new Pair(i, j));
        }
        if(grid[i][j] == 1) {
         fresh++;
        }
    }
}
if(fresh == 0) return 0;
      while(!q.isEmpty()) {
        int size = q.size(); 
        for(int j = 0; j < size; j++) {
        Pair p = q.poll();
        int row = p.row;
        int col = p.col;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
     if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
        grid[nr][nc] = 2;
        fresh--;
        q.add(new Pair(nr , nc));
     }
            }
        }
      minute++;
      if (fresh == 0) {
    break;
}
      }
         if(fresh > 0) {
            return -1;
        }
      return minute;
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
// here we put the while loop out of the for loop as we have to act simultaneously on all the rotten oranges and it is time senstive we have to return the time..as if the while loop is inside the for loop then first it select the first oraange then do its bfs and then the other orange and then thats bfs !