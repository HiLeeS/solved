import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    int n;
    
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        n = numbers.length();
        
        dfs(numbers, new StringBuilder());
        
        for(int num : set){
            if(is_prime(num)) answer++;
        }
        
        
        return answer;
    }
    
    public void dfs(String numbers, StringBuilder sb){
        
        if (sb.length() > 0) {
            set.add(Integer.parseInt(sb.toString()));
        }
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            
            sb.append(numbers.charAt(i));
            dfs(numbers, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
            
        }
    }
    
    
    public boolean is_prime(int i){
        if(i < 2) return false;
        
        for(int j = 2; j*j <= i; j++){
            if(i % j == 0) return false;
        }
        
        return true;
    }
}