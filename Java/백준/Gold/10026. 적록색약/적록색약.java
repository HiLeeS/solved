import java.io.*;
import java.util.*;

public class Main {
    
    static char[][] map;
    static char[][] rgb_map;
    static boolean[][] visited;
    static boolean[][] rgb_visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new char[n][n];
        rgb_map = new char[n][n];
        visited = new boolean[n][n];
        rgb_visited = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                char c = s.charAt(j);
                map[i][j] = c;
                if(c == 'G'){
                    rgb_map[i][j] = 'R';
                }
                else{
                    rgb_map[i][j] = c;
                }
            }
        }

        int count = 0;
        int rgb_count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    count++;
                }

                if(!rgb_visited[i][j]){
                    rgb_bfs(i,j);
                    rgb_count++;
                }
            }
        }
        System.out.print(count+" "+rgb_count);

    }

    static void bfs(int x, int y){
        char start = map[x][y];
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if(!visited[nx][ny] && map[nx][ny] == start){
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }

    static void rgb_bfs(int x, int y){
        char start = rgb_map[x][y];
        rgb_visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if(!rgb_visited[nx][ny] && rgb_map[nx][ny] == start){
                        rgb_visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        } 
    }

}
