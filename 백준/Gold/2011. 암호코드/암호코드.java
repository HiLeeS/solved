/*
앞에가 2일때와 1일때에 따라 다름
앞에가 2일때는 0~6
앞에가 1일대는 0~9
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        if (n == null || n.isEmpty() || n.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n.length()+1];
        dp[0] = 1;
        dp[1] = 1;  
        
        for (int i = 2; i <= n.length(); i++) {
            char cur = n.charAt(i - 1);
            char prev = n.charAt(i - 2);

            // 1자리
            if (cur >= '1' && cur <= '9') {
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }

            // 2자리
            int val = (prev - '0') * 10 + (cur - '0');
            if (val >= 10 && val <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }
        }

        System.out.println(dp[n.length()]);

    }
    
}
