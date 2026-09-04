import java.util.*;
class Solution {
    int n = 0;
    int m = 0;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        bfs(maps);
        
        if(maps[n-1][m-1] != 1){
            return maps[n-1][m-1];
        }
        else{
            return -1;
        }
    }
    
    public void bfs(int[][] maps){
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i < 4; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                
                if(x >= 0 && x < n && y >= 0 && y < m){
                    if(!visited[x][y] && maps[x][y] != 0){
                        visited[x][y] = true;
                        maps[x][y] = maps[cur[0]][cur[1]] + 1;
                        q.offer(new int[]{x, y});
                    }
                }
            
            }
            
        }
    
    }
    
}