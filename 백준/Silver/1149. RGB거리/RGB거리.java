import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dp;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        adj = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = adj[0][0];
        dp[0][1] = adj[0][1];
        dp[0][2] = adj[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + adj[i][0], dp[i - 1][2] + adj[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + adj[i][1], dp[i - 1][2] + adj[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + adj[i][2], dp[i - 1][1] + adj[i][2]);
        }
        int result = Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]);
        System.out.println(result);
    }
}