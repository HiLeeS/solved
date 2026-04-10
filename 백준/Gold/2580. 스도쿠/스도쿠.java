import java.io.*;
import java.util.*;

public class Main {

    static int[][] map = new int[9][9];
    static int zero_count = 0;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;

        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 0) zero_count++;
            }
        }


        backtracking(0);  //x, y, size

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        
    }

    static void backtracking(int size){
        if(size == zero_count){
            flag = true;
            return;
        }

        if(flag) return;
        

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(map[i][j] != 0) continue;
                
                List<Integer> nums = check(i, j);
                
                if(nums.size() == 0){
                    return;
                }

                for(int num : nums){
                    map[i][j] = num;
                    backtracking(size+1);
                    if(flag) return;
                    map[i][j] = 0;
                }

                return;

            }
        }

    }

    static List<Integer> check(int x, int y){

        boolean[] num = new boolean[10];
        List<Integer> nums = new ArrayList<>();
        
        // 가로 세로 검사
        for(int i = 0; i < 9; i++){
            num[map[x][i]] = true;
            num[map[i][y]] = true;
        }

        int nx = 0;
        int ny = 0;

        for(int i = 0; i < 9; i+=3){
            for(int j = 0; j < 9; j+=3){
                 if(x >= i && x < i+3 && y >= j && y < j+3){
                    nx = i;
                    ny = j;
                    break;
                 }
            }
        }

        //네모 검사
        for(int i = nx; i < nx+3; i++){
            for(int j = ny; j < ny+3; j++){
                if(num[map[i][j]]) continue;
                
                num[map[i][j]] = true;

            }
        }

        for(int i = 1; i < 10; i++){
            if(!num[i]) nums.add(i);
        }
        
        return nums;

    }

}