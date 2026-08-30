class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor = image[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        if(image[sr][sc] == color) {
            return image;
        }
        if(image[sr][sc] != color) {
            image[sr][sc] = color;
            q.add(new Pair(sr, sc));
            while(!q.isEmpty()) {
                Pair p = q.poll();
                int row = p.row;
                int col = p.col;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if(nr >= 0 && nr < image.length &&
   nc >= 0 && nc < image[0].length &&
   image[nr][nc] == oldcolor) {
    image[nr][nc] = color;
    q.add(new Pair(nr , nc));
   }
        }
            }
        }
        return image;
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