class Solution {
    public int[] solution(int[] prices) {
        
        int length = prices.length;
        int[] answer = new int[prices.length];
        
        int sum = 0;
        
        for(int i = length-1; i >= 0; i--){
            if(i == length-1){
                answer[i] = 0;
                continue;
            }
            
            for(int j = i+1; j < length; j++){
                if(prices[j] < prices[i]){
                    sum++;
                    break;
                }
                sum++;
                
            }
            answer[i] = sum;
            sum = 0;
            
        }
        
        
        return answer;
    }
}