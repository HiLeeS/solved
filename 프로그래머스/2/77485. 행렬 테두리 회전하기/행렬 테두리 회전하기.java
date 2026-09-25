class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];
        
        for(int i = 1; i < rows+1; i++){
            for(int j = 1; j < columns+1; j++){
                map[i][j] = ((i-1) * columns + j);
            }
        }
        
        int idx = 0;
        
        for(int[] query : queries){
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            
            //모서리 = x1y1 x1y2 x2y1 x2y2
            int start = map[x1][y1];
            int curx = x1;
            int cury = y1;
            int min = start;
            while(true){
                
                if(curx >= x1 && curx < x2 && cury == y1) {    //왼쪽
                    map[curx][cury] = map[curx+1][cury];
                    curx++;
                }
                else if(curx == x2 && cury >= y1 && cury < y2){    //하단
                    map[curx][cury] = map[curx][cury+1];
                    cury++;
                }
                
                else if(curx > x1 && curx <= x2 && cury == y2){    //오른쪽
                    map[curx][cury] = map[curx-1][cury];
                    curx--;
                }
                
                else if(curx == x1 && cury > y1 && cury <= y2){    //상단
                    if(cury == y1+1){
                        map[curx][cury] = start;
                    }
                    else{
                        map[curx][cury] = map[curx][cury-1];
                    }
                    cury--;
                }
                
                if(map[curx][cury] < min) min = map[curx][cury];
                if(curx == x1 && cury == y1) break;
            }
            
            
            
            answer[idx++] = min;
            
        }
        
        return answer;
    }
}