import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] nums;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        sum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        int left = 0;
        int right = 0;
        int result = (int) 1e9 + 1;
        while (left <= right) {
            if (right == N) break;
            int s = sum[right] - sum[left] + nums[left];
            if (s < S) {
                right++;
            } else {
                //그만 더해도..?
                result = Math.min(right - left+1, result);
                left++;
            }
        }

        System.out.println(result == (int) 1e9 + 1 ? 0 : result);
    }
}