//완전탐색 + 백트래킹으로 풀이 -> 제출에 런타임에러(Number Format 발생)
//입력에서 10의 5승이라고 했을 때 100000 자리수라고 파악했지만 매우 큰 수 였다..
import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int sum = 0;
        boolean hasZero = false;
        char[] arr = s.toCharArray();

        for (char c : arr) {
            int d = c - '0';
            sum += d;
            if (d == 0) hasZero = true;
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.print(-1);
            return;
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(arr.length);
        for (int i = arr.length - 1; i >= 0; i--) sb.append(arr[i]);

        System.out.print(sb.toString());
    }
    
}
