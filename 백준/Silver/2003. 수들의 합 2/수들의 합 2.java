import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result;
    static int[] sum;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;

        int s = 0;
        while (left <= right && right <= N) {
            s = sum[right] - sum[left];

            if (s == M) {
                right++;
                left++;
                result++;
            } else if (s > M) {
                //합이 원하는 값 보다 크다? 더 많이 뺴준다.
                left++;
            } else {
                right++;
            }
        }

        System.out.println(result);
    }
}