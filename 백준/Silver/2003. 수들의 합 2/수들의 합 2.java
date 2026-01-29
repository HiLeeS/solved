import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n+1];
        int[] a = new int[n+1];
        a[0] = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            a[i] = arr[i] + a[i-1];
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i+1; j <= n; j++){
                sum = a[j] - a[i];
                if(sum == m) count++;
            }
            
        }

        System.out.println(count);

    }
}
