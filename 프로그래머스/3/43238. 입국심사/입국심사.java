import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
                
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) n * times[0];
        long mid = right / 2;
        
        while(left < right){
            long sum = 0;
            mid = (left + right) / 2;

            for(int i = 0; i < times.length; i++){
                sum += mid / times[i];
            }
            
            if(sum >= n){
                right = mid;
            }
            else{
                left = mid + 1; 
            }
        }
        
        
        
        
        return left;
    }
}