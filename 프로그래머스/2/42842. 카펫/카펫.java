/*
공식을 생각해서 풀이함
answer = [가로, 세로]
brown = (yellow / j) * 2 + (i * 2)
j = 1부터 시작 / i = 3부터 시작
i는 줄 수임
i가 세로의 길이가 됨
i 로 가로를 구해보고자 함.
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int i = 3;
        int j = 1;
        int sum = 0;
        while(true){
            if (yellow % j == 0) {
                i = j + 2;
                sum = (yellow / j)*2 + (i * 2);
                if(sum == brown){
                    break;
                }
            }
            j++;
        }
        
        answer[1] = i;
        answer[0] = (yellow/j) + 2;
        
        return answer;
    }
}