import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] adj;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            adj[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = adj[1];
        if(N>=2){
            dp[2] = adj[1] + adj[2];
        }

        for (int i = 3; i < N + 1; i++) {
            //지금껄 먹는다? 내 전꺼는 못먹는다
            dp[i] = Math.max(dp[i - 3] + adj[i - 1] + adj[i], dp[i - 2] + adj[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[N]);
    }
}