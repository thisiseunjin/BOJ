import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[Math.max(5, n + 1)];

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int i = 4; i < n + 1; i++) {
            dp[i] = (dp[i-1]+(dp[i-2])*2)%10_007;
        }

        System.out.println(dp[n]);

    }
}