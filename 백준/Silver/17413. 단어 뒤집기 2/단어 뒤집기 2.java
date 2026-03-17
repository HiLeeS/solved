/*
앞에가 2일때와 1일때에 따라 다름
앞에가 2일때는 0~6
앞에가 1일대는 0~9
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] array = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        boolean turn = false;
        for(int i = 0; i < s.length(); i++) {
            if(array[i] == '<'){
                sb.append(temp.reverse().toString());
                turn = true;
                temp = new StringBuilder();
            }

            else if(array[i] == '>'){
                sb.append(array[i]);
                turn = false;
                continue;
            }
            
            if(turn){
                sb.append(array[i]);
            }

            else{
                if(array[i] == ' '){
                    sb.append(temp.reverse().toString());
                    sb.append(" ");
                    temp = new StringBuilder();
                }
                else{
                    temp.append(array[i]);
                }
            }
        }
        if(temp.length() != 0){
            sb.append(temp.reverse().toString());
        }

        System.out.print(sb.toString());

    }
    
}
