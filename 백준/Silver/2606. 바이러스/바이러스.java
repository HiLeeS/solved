import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    static List<List<Integer>> graph = new ArrayList<>();;
    static int n;
    static int m;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        
        for(int i = 0; i < m; i++){        
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);   
        }
        
        bfs(1);
        
        System.out.print(count);
    }
    
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : graph.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
            
        }
        
    }
    
}
