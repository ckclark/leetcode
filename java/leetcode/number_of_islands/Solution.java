package leetcode.number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int w = grid[0].length;
        int h = grid.length;
        Queue<Point> queue = new LinkedList<Point>();
        int solution = 0;
        for(int x = 0; x < h; x++){
            for(int y = 0; y < w; y++){
                if(grid[x][y] == '1'){
                    solution++;
                    queue.offer(new Point(x, y));
                    grid[x][y] = '0';
                    while(!queue.isEmpty()){
                        Point cur = queue.remove();
                        int nx, ny;
                        nx = cur.x - 1;
                        ny = cur.y;
                        if(0 <= nx && nx < h && 0 <= ny && ny < w && grid[nx][ny] == '1'){
                            grid[nx][ny] = '0';
                            queue.offer(new Point(nx, ny));
                        }
                        nx = cur.x + 1;
                        ny = cur.y;
                        if(0 <= nx && nx < h && 0 <= ny && ny < w && grid[nx][ny] == '1'){
                            grid[nx][ny] = '0';
                            queue.offer(new Point(nx, ny));
                        }
                        nx = cur.x;
                        ny = cur.y - 1;
                        if(0 <= nx && nx < h && 0 <= ny && ny < w && grid[nx][ny] == '1'){
                            grid[nx][ny] = '0';
                            queue.offer(new Point(nx, ny));
                        }
                        nx = cur.x;
                        ny = cur.y + 1;
                        if(0 <= nx && nx < h && 0 <= ny && ny < w && grid[nx][ny] == '1'){
                            grid[nx][ny] = '0';
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        return solution;
    }
}
