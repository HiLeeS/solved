import java.util.*;
class Solution {
    int answer = 0;
    int n; int m;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        
        n = land.length; //5 
        m = land[0].length; //8 
        visited = new boolean[n][m];
        
        int[] oilByCol = new int[m];    //각 열마다 몇칸의 석유를 얻을 수 있는지 저장함
        
        for(int i = 0; i < n; i++){ 
            for(int j = 0; j < m; j++){ 
                if(!visited[i][j] && land[i][j] == 1) 
                    bfs(i, j, land, oilByCol); 
            } 
        } 
        
        return answer; 
    } 
    
    void bfs(int y, int x, int[][] map, int[] oilByCol){
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> cols = new HashSet<>();
        
        q.offer(new int[]{y, x}); 
        
        visited[y][x] = true; 
        int count = 1; //현재 위치 석유 
        
        
        while(!q.isEmpty()){ 
            int[] now = q.poll(); 
            y = now[0]; 
            x = now[1];
            cols.add(x);
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i]; 
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){ 
                    if(!visited[ny][nx] && map[ny][nx] == 1){
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny,nx});
                        count++; 
                    } 
                } 
            }
        } 
        
        for (int col : cols) {
            oilByCol[col] += count;
            answer = Math.max(answer, oilByCol[col]);
        }
        
    }
}