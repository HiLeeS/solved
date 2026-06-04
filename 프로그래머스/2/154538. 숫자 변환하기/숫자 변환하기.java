import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        if(x == y){
            return 0;
        }
        
        int[] arr = new int[y+1];
        
        Arrays.fill(arr, 1000001);
        
        arr[x] = 0;
        for(int i = x; i <= y; i++){
            
            
            if(i+n <= y){
                arr[i+n] = Math.min(arr[i] + 1, arr[i+n]);    //최소 이동 횟수 저장
            }
            
            if(i*2 <= y){
                arr[i*2] = Math.min(arr[i] + 1, arr[i*2]);
            }
            
            if(i*3 <= y){
                arr[i*3] = Math.min(arr[i] + 1, arr[i*3]);
            }
            
            
        }
        
        if(arr[y] == 1000001){    //방문한 적이 없을 경우
            answer = -1;
        }
        
        else{   //방문한 경우
            answer = arr[y];
        }
        
        return answer;
    }
}