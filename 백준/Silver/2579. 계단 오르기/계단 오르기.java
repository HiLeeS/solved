/* 
연속된 세 개의 계단을 모두 밟으면 안됨
마지막 도착 계단은 반드시 밟아야 함.
dp[i] 에 올 수 있는 경우는 dp[i-2](2칸 뛰기) or dp[i-3] + steps[i-1](1칸)


*/

import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] steps = new int[n];

        for(int i = 0; i<n; i++){
            steps[i] = Integer.parseInt(br.readLine());
        }
        
        if(n < 3){
            int sum = 0;
            for(int num : steps){
                sum += num;
            }
            System.out.print(sum);
            return;
        }

        int[] dp = new int[n];
        
        dp[0] = steps[0];   //1칸 
        dp[1] = dp[0] + steps[1];    //2번째 계단 
        dp[2] = Math.max(steps[2] + steps[0], steps[1]+steps[2]);   //3번째 계단(1+3 or 2+3)
        
        for(int i = 3; i < n; i++){
            dp[i] = Math.max(dp[i-3] + steps[i-1] + steps[i], dp[i-2] + steps[i]);

        }

        System.out.print(dp[n-1]);

    }

    
}
