
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] belt = new int[n*2];
        boolean[] robot = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*n; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }
        

        int count;  //내구도 수 측정
        int answer = 0;

        while(true){
            count = 0;

            //과정 1(벨트 이동)
            int value = belt[(2*n) - 1];
            for(int i = (2*n) - 1; i > 0; i--){
                belt[i] = belt[i-1];
            }
            belt[0] = value;

            for(int i = n - 1; i > 0; i--){
                robot[i] = robot[i-1];
            }
            robot[0] = false;
            robot[n-1] = false;

            //과정 2
            for(int i = n - 2; i >= 0; i--){
                if(robot[i] && !robot[i+1] && belt[i+1] > 0){
                    robot[i] = false;
                    robot[i+1] = true;
                    belt[i+1] -= 1;
                }
            }
            robot[n-1] = false; //내리는 위치 로봇 제거


            //과정 3
            if(belt[0] != 0){
                robot[0] = true;
                belt[0]-= 1;
            }
            
            //과정 4
            for(int num : belt){
                if(num == 0){
                    count++;
                }
            }
            answer++;
            if(count >= k) break;
        }

        System.out.print(answer);
    }

}
