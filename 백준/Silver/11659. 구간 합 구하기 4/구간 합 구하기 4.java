import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] nums;
    static int[] sums;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        sums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int n = Integer.parseInt(st.nextToken());
            nums[i] = n;
            sums[i] = n + sums[i - 1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            sb.append(sums[right] - sums[left - 1]).append("\n");
        }

        System.out.print(sb);
    }
}