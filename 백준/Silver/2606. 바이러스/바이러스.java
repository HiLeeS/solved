import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<List<Integer>> graph = new ArrayList<>();
    static int answer = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        visited = new boolean[n+1];
     
        bfs(1);
        System.out.print(answer);


    }

    static void bfs(int start){
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : graph.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    answer++;
                }
            }

        }
    }

}