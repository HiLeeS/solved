import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        
        int turn = 1;
        int i = 0;
        while(turn <= x){
            i++;
            turn += i;
        }
        
        turn -= i;
        
        int child = 0;
        int parent = 0;
        int n = x - turn;
        if(i % 2 == 0){
            child = 1 + n;
            parent = i - n;
        }
        else{
            child = i - n; 
            parent = 1 + n;
        }
        
        System.out.print(child+"/"+parent);
        
    }
}
