import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int total = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
            total += number[i];
        }
        
            
        for(int i = 0; i < discount.length - 9; i++){
            Map<String, Integer> now = new HashMap<>(map);
            int count = total;
            
            for(int j = i; j < i+10; j++){
                if(now.containsKey(discount[j]) && now.get(discount[j]) > 0){
                    now.put(discount[j], now.get(discount[j]) - 1);
                    count--;
                }
            }
            if(count <= 0){
                answer++;
            }
        }
        
        return answer;
    }
}