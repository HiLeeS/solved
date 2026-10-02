import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        
        int answer = 0;
        List<List<Integer>> list = new ArrayList<>();
        int[] visited = new int[n+1];
        
        for(int i = 0; i < n+1; i++){
            list.add(new ArrayList<>());
        }
        for(int[] e : edge){
            int n1 = e[0];
            int n2 = e[1];
            
            list.get(n1).add(n2);
            list.get(n2).add(n1);
            
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 1;
        
        int max = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list.get(now)){
                if(visited[next] == 0){
                    q.offer(next);
                    visited[next] = visited[now] + 1;
                    max = Math.max(max, visited[next]);
                }
                
            }
            
            
        }
        
        for(int i = 0; i < visited.length; i++){
            if(max == visited[i]) answer++;
        }
        
        return answer;
    }
    
    
}