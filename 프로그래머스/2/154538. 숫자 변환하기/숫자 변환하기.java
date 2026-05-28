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
        int temp = 0;
        for(int i = x; i <= y; i++){
            
            
            if(i+n <= y){
                temp = arr[i] + 1;  //이동횟수 + 1
                if(arr[i+n] != 0){  //이미 기록이 있는 경우
                    arr[i+n] = Math.min(temp, arr[i+n]);    //최소 이동 횟수 저장
                }
                else{   //처음 방문시
                    arr[i+n] = temp;
                }
            }
            
            if(i*2 <= y){
                temp = arr[i] + 1;
                if(arr[i*2] != 0){
                    arr[i*2] = Math.min(temp, arr[i*2]);
                }
                else{
                    arr[i*2] = temp;
                }
            }
            
            if(i*3 <= y){
                temp = arr[i] + 1;
                if(arr[i*3] != 0){
                    arr[i*3] = Math.min(temp, arr[i*3]);
                }
                else{
                    arr[i*3] = temp;
                }
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