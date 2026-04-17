import java.io.*;
import java.util.*;

//회전해야할 겹은 한 층마다 8개씩 늘어남

public class Main {

    static int[][] A;
    static int N;
    static int M;
    static int K;
    static int[][] rcs;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rcs = new int[K][3];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            rcs[i][0] = Integer.parseInt(st.nextToken()) - 1;   //입력값이랑 A배열 맞추기 위해 1마이너스  
            rcs[i][1] = Integer.parseInt(st.nextToken()) - 1;
            rcs[i][2] = Integer.parseInt(st.nextToken());

        }
        
        visited = new boolean[K];

        dfs(0, A);

        System.out.print(answer);


    }

    static void dfs(int count, int[][] map){
        if(count == K){
            //최솟값 찾기
            for(int i = 0; i < N; i++){
                int sum = 0;
                for(int j = 0; j < M; j++){
                    sum += map[i][j];
                }
                if(answer > sum){
                    answer = sum;
                }
            }

        }


        for(int i = 0; i < K; i++){
            if(visited[i]) continue;
            visited[i] = true;

            //맵 돌리는 함수 호출
            turn(i, map);

            dfs(count+1, map);
            
            //백트래킹
            rturn(i, map);
            visited[i] = false;

        }
    }

    static void turn(int now, int[][] map){
        int r = rcs[now][0];
        int c = rcs[now][1];
        int s = rcs[now][2];


        for(int i = 1; i < s+1; i++){
            int temp = map[r-i][c-i];
            
            int x = r-i;
            int y = c-i;

            int t_count = i*2;
            int num = 0;
            int turn = 0;   //남 북 서 동 으로 이동
            for(int j = 1; j < i*8; j++){

                if(turn == 0){  //아래
                    map[x][y] = map[x+1][y];
                    x++;

                }
                else if(turn == 1){ //오른쪽
                    map[x][y] = map[x][y+1];
                    y++;

                }
                else if(turn == 2){ //위
                    map[x][y] = map[x-1][y];
                    x--;
                }
                else if(turn == 3){ //왼쪽
                    map[x][y] = map[x][y-1];
                    y--;
                    
                }

                num++;
                turn = num/t_count;


            }
            map[r-i][c-i+1] = temp;

        }

    }

    static void rturn(int now, int[][] map){
        int r = rcs[now][0];
        int c = rcs[now][1];
        int s = rcs[now][2];


        for(int i = 1; i < s+1; i++){
            int temp = map[r-i][c-i];
            
            int x = r-i;
            int y = c-i;

            int t_count = i*2;
            int num = 0;
            int turn = 0;   //동 남 서 북 으로 이동
            for(int j = 1; j < i*8; j++){

                if(turn == 0){  //오른쪽
                    map[x][y] = map[x][y+1];
                    y++;

                }
                else if(turn == 1){ //아래
                    map[x][y] = map[x+1][y];
                    x++;

                }
                else if(turn == 2){ //왼쪽
                    map[x][y] = map[x][y-1];
                    y--;
                }
                else if(turn == 3){ //위
                    map[x][y] = map[x-1][y];
                    x--;
                    
                }

                num++;
                turn = num/t_count;


            }
            map[r-i+1][c-i] = temp;

        }
    
    }

}