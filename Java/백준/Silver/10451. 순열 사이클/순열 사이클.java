import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    static int[] arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 0; test_case < t; test_case++){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 1; i <= n; i++){
                if(!visited[i]) cycle(i);
                
            }
            
            sb.append(count+"\n");
            
        }
        System.out.print(sb);
        
    }
    static void cycle(int start){
        visited[start] = true;
        
        Deque<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(true){
            int cur = arr[q.poll()];
            
            if(cur == start){
                count++;
                return;
            }
            else{
                visited[cur] = true;
                q.offer(cur);
            }
            
        }
        
    }
    
}
