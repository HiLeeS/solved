import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] arr;
    static List<Integer> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(new ArrayList<>(), 0);
        System.out.print(sb);

    }

    static void backTracking(List<Integer> nums, int start){
        if(nums.size() == k){
            for(int num:nums){
                sb.append(num+" ");

            }
            sb.append("\n");
            return;
        }

        int prev = -1;

        for(int i = start; i < n; i++){
            if(prev == arr[i]) continue;

            nums.add(arr[i]);
            prev=arr[i];
            backTracking(nums, i);
            nums.remove(nums.size()-1);
        }
    }   
    
}
