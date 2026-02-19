import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long count = 0;

        long i = 1;
        long sum = 0;
        while(true){
            if(sum + i < n) {
                sum += i;
                count++;
                i++;
            }
            else if(sum + i == n) {
                count++;
                break;
            }
            else {
                break;
            }

        }

        System.out.println(count);
    }
}
