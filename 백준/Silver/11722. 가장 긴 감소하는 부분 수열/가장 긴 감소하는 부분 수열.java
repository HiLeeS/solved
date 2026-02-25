
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        // 본인만 측정일 때 1로 초기화
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(A[i] < A[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, dp[i]);
        System.out.print(ans);

    
    }
}
