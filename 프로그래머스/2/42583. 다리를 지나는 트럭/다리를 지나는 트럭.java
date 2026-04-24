//일차선이라 한 번에 한 개의 트럭만 진입 가능
//bridge_length = 길이 1이 1초
//다리 = queue, queue.sum() <= weight
//while 문? for문?
//트럭이 다리 얼마나 건넜는지도 파악해야 할 듯?? [truck_weights에서 뽑을 때마다 해당 트럭을 count로 해서 체크하는게 나을 듯]
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1; //전체 시간 체크
        
        Queue<Integer> q = new LinkedList<>();
        
        int truck_count = truck_weights.length; //이동해야할 트럭 수
        int sum = 0;    //다리 위에 있는 트럭들 무게 총 합
        int i = 0; //현재 이동 중인 마지막 트럭 idx
        
        while(truck_count != 0){
            //다리 무게랑 현재 트럭들 무게 확인 로직
            if(i < truck_weights.length && (weight - sum) >= truck_weights[i]){
                //큐에 트럭 넣는 로직
                q.offer(truck_weights[i]);
                sum += truck_weights[i];
                truck_weights[i] = bridge_length;
                i++;
            }
            
            //시간 1초 지나는 로직
            for(int truck = 0; truck < i; truck++){
                if(truck_weights[truck] == 0){
                    truck_weights[truck] = -1;
                    continue;
                }
                truck_weights[truck]--;
                
            }
            
            //다리위에 올라간 트럭들 중 도착한 트럭 확인
            for(int truck = 0; truck < i; truck++){
                if(truck_weights[truck] == 0){
                    int now = q.poll();
                    truck_count--;
                    sum -= now;
                }
            }
            answer++;   //1초 증가  
        }
        
        return answer;
    }
}