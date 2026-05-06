// 첫 생각 : 투 포인터로 정렬된 people에서 당겨오면서 양 포인터의 합이 limit보다 작으면 answer 1 추가 ?
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);    //투 포인터를 위해 정렬
        
        int start = 0;  //시작 위치
        int end = people.length-1;  //마지막 위치
        
        
        while(start < end){ //두 포인터가 겹치기 전까지 반복
            int sum = people[start] + people[end];
            if(sum <= limit) {  //보트에 탈 수 있으면
                answer++;
                people[start] = 0;
                people[end] = 0;
                start++;
                end--;
            }
            else if(sum > limit){   //보트 제한 무게보다 높으면 end를 당김
                end--;
            }
        }
        
        for(int i = 0; i < people.length; i++){ //혼자 보트를 타야하는 경우
            if(people[i] != 0) answer++;
        }
        
        
        return answer;
    }
}