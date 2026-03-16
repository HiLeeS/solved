
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int n = S.length();

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = i+1; j <= n; j++){
                String str = S.substring(i,j);
                set.add(str);
            }
        }
        
        System.out.print(set.size());
    }

}
