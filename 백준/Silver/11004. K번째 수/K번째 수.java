import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;
    static long[] nums;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new long[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);

        System.out.print(nums[K-1]);
    }
}