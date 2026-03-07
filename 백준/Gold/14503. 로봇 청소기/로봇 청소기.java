import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        
        st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());   //0 북, 1 동, 2 남, 3 서
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        
        int ans = 0;
        while(true){
            if(map[r][c] == 0){ //1 옵션
                map[r][c] = 2;  //2는 청소
                ans++;
            }
            
            boolean turn = false;
            for(int i = 0; i < 4; i++){ //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸
                int nr = r + dy[i];
                int nc = c + dx[i];
                if(map[nr][nc] == 0){   //빈 칸이 있는 경우
                    turn = true;
                    break;
                }
            }
            
            if(!turn){  //주변에 청소되지 않은 칸이 없는 경우
                int back = (d+2)%4;
                if(map[r+dy[back]][c+dx[back]] != 1){   //후진이 가능할 경우
                    r = r+dy[back];
                    c = c+dx[back];
                    continue;
                }
                else{
                    break;
                }
            }
            
            else{   //주변에 청소되지 않은 칸이 있는 경우
                d = (d+3)%4;    
                int nr = r + dy[d];
                int nc = c + dx[d];
                if(map[nr][nc] == 0){
                    r = nr;
                    c = nc;
                }
            }
            
        }
        
        System.out.print(ans);
    }
}
