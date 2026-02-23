/* 서쪽에 N개, 동쪽에 M개 사이트가 존재 (N <= M)
서로 겹치지 않아야 함.
- 동쪽 M개 중에서 N개를 고르는 방법의 수
- 조합 C(M, N) 문제

DP로 풀면
- dp[n][m] = 동쪽 m개 중에서 서쪽 n개를 선택해서 다리놓는 경우의 수
- 점화식 : 동쪽의 마지막(=M번쨰)을 쓰는 경우/안 쓰는 경우로 나눔
- M번째 동쪽 사이트를 안쓰면 dp[n][m-1]
- M번째 동쪽 사이트를 쓰면 나머지 n-1개를 m-1개 중에서 뽑아야 함. dp[n-1][m-1]
- 따라서 점화식은 dp[n][m] = dp[n][m-1] + dp[n-1][m-1]
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            long[][] dp = new long[n+1][m+1];
            
            //초기화 : 동쪽 j개 중 0개 고르는 방법 1가지
            for (int j = 0; j <= m; j++) {
                dp[0][j] = 1;
            }
            
            //초기화 : 동쪽과 서쪽의 수가 같은 경우 1가지
            for (int i = 0; i <= n && i <= m; i++) {
                dp[i][i] = 1;
            }
            
            //점화식으로 값 채우기
            for(int i = 1; i <= n; i++){    
                for(int j = i; j <= m; j++){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
            }

            sb.append(dp[n][m]+"\n");
        }

        System.out.print(sb.toString());

    }
}
