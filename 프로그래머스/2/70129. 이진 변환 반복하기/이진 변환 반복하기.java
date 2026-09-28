class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while(!s.equals("1")){
            int len = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0') len++;
            }
            
            int size = s.length() - len;
            s = Integer.toBinaryString(size);
            
            answer[0]++;
            answer[1] += len;
            
        }
        
        return answer;
    }
}