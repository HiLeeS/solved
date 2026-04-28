// 내가생각하는 최저 시간의 핵심은 마지막 사람들의 남은 수와 현재 심사받을 수 있는 최저의 사람 수랑 비교하는 것
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times); //시간 정렬
        
        int min = times[0];
        
        for(long i = min; i < min*n; i++){   //최대 시간은 심사시간이 제일 작은걸로다 돌리기 
            
            int num = 0;
            for(int time = 0; time < times.length; time++){
                num += i / times[time];
            }
            if(num >= n){
                answer = i;
                break;
            }
        }
        
        
        
        return answer;
    }
}