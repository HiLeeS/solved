import java.io.*;
import java.util.*;

public class Main {
    
    static int n, count = 0;
    static boolean[] col;
    static boolean[] diag1; // r - c + n
    static boolean[] diag2; // r + c
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        col = new boolean[n];
        diag1 = new boolean[n+n];
        diag2 = new boolean[n+n];
        
        dfs(0);

        System.out.print(count);
    }

    static void dfs(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || diag1[row - c + n] || diag2[row + c]) continue;

            col[c] = diag1[row - c + n] = diag2[row + c] = true;
            dfs(row + 1);
            col[c] = diag1[row - c + n] = diag2[row + c] = false;
        }
    }

    
}
