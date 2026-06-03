class Solution {
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        
        int n = arr.length;
        back_tracking(n, arr, 0, 0);

        return answer;
    }
    
    void back_tracking(int cur_size, int[][] arr, int r, int c){
        
        if(compare(arr[r][c], cur_size, arr, r, c)){
            answer[arr[r][c]]++;
            return;
        }
        
        int next_size = cur_size / 2;
        
        back_tracking(next_size, arr, r, c);    //2사분면
        
        back_tracking(next_size, arr, r + next_size, c);    //3사분면
        
        back_tracking(next_size, arr, r, c + next_size);    //1사분면
        
        back_tracking(next_size, arr, r+ next_size, c+ next_size);    //4사분면
        
        
    }
    
    boolean compare(int start, int size, int[][] arr, int r, int c){    //영역의 숫자가 다 같은지 비교
        
        for(int i = r; i < r+size; i++){
            for(int j = c; j < c+size; j++){
                if(arr[i][j] != start){
                    return false;
                }
                
            }
        }
        return true;
        
    }
    
}