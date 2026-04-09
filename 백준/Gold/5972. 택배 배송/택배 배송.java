import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int to;
        int cost;

        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static int[] dist;
    static List<List<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());
            int C_i = Integer.parseInt(st.nextToken());

            list.get(A_i).add(new Node(B_i, C_i));
            list.get(B_i).add(new Node(A_i, C_i));
        
        }
        
        dijkstra(1);

        System.out.print(dist[n]);

    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        Arrays.fill(dist, Integer.MAX_VALUE);
    
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            //이미 가중치가 더 작다면 스킵
            if(now.cost > dist[now.to]) continue;
            

            for(Node next : list.get(now.to)){
                int nextCost = dist[now.to] + next.cost;

                if(nextCost < dist[next.to]){
                    dist[next.to] = nextCost;
                    pq.offer(new Node(next.to, nextCost));
                }

            }

        }
    
    
    
    }

}