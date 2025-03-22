import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] steps;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        steps = new int[300];
        dp = new int[300];

        for (int i = 0; i < N; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = steps[0];
        dp[1] = Math.max(steps[0] + steps[1], steps[1]);
        dp[2] = Math.max(steps[0] + steps[2], steps[1] + steps[2]);

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 3] + steps[i - 1] + steps[i], dp[i - 2] + steps[i]);
        }

        System.out.println(dp[N - 1]);
    }
}