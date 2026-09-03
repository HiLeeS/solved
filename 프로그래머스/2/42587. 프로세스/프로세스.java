import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {

        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            q.offer(new int[]{priorities[i], i});
        }
        
        while(true){
            
            int[] cur = q.poll();
            boolean check = false;
            
            for(int i = 0; i < q.size(); i++){
                int[] now = q.poll();
                
                if(cur[0] < now[0]){
                    check = true;
                }
                
                q.offer(now);
            }
            
            if(check){
                q.offer(cur);
            }
            
            else{
                answer++;
                if(cur[1] == location){
                    return answer;
                }
            }
        }
        
        
        //return answer;
    }
}