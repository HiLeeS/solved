/*
앞에가 2일때와 1일때에 따라 다름
앞에가 2일때는 0~6
앞에가 1일대는 0~9
*/

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] arr;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        boolean[] visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, visited, 500);

        System.out.print(count);

    }

    static void backTracking(int size, boolean[] visited, int sum){
        if(sum < 500){
            return;
        }
        if(size == n){
            if(sum < 500){
                return;
            }
            count++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            sum += arr[i] - k;
            size++;
            backTracking(size, visited, sum);
            sum -= arr[i] - k;
            size--;
            visited[i] = false;

        }


    }   
    
}
