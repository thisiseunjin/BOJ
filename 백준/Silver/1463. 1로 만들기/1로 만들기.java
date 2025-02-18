import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[N] = 0;
        for (int i = N; i > 0; i--) {
            //지금 내가 할 수 있는 일
            if (i % 3 == 0) {
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            }
            if (i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            }

            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
        }

        System.out.println(dp[1]);

//        System.out.println(Arrays.toString(dp));
    }
}