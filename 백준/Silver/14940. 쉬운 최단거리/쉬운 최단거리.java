import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m];
        
        int x = 0;
        int y = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    sb.append(-1+" ");
                }
                else{
                    sb.append(map[i][j]+" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        map[x][y] = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();

            int cur_x = now[0];
            int cur_y = now[1];
            for(int i = 0; i < 4; i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        map[nx][ny] = map[cur_x][cur_y]+1;
                    }
                }
            }
        }
    }
}
