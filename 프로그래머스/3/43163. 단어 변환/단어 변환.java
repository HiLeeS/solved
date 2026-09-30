import java.util.*;
class Solution {
    
    class Node {
        String word;
        int count;
        
        Node(String word, int count){
            this.word = word;
            this.count = count;
            
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<Node> q = new LinkedList<>();
        
        boolean[] visited = new boolean[words.length];
        int len = begin.length();
        
        q.offer(new Node(begin, 0));
        
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            String word = cur.word;
            int count = cur.count;
            
            if(word.equals(target)) return count;
            
            
            for(int i = 0; i < words.length; i++){
                int c = 0;
                
                for(int j = 0; j < len; j++){
                    if(word.charAt(j) == words[i].charAt(j)) c++;
                }
                
                if(c != len - 1) continue;
                if(visited[i]) continue;
                
                visited[i] = true;
                
                q.offer(new Node(words[i], count+1));
                
            }
            
        }
        
        
        
        
        
        return answer;
    }
}