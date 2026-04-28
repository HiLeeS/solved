// 내가생각하는 최저 시간의 핵심은 마지막 사람들의 남은 수와 현재 심사받을 수 있는 최저의 사람 수랑 비교하는 것
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long min = times[0];
        for (int i = 1; i < times.length; i++) {
            if (times[i] < min) {
                min = times[i];
            }
        }
        
        long left = 1;
        long right = min * n;
        long mid = (left+right) / 2;
        
        while(left != right){
            long num = 0;
            for(int time = 0; time < times.length; time++){
                num += mid / times[time];
            }
            
            if(num < n){
                left = mid + 1;
                mid = (left+right) / 2;
            }

            else if(num >= n){
                answer = mid;
                right = mid;
                mid = (left+right) / 2;
            }
             
        }

        return answer;
    }
}