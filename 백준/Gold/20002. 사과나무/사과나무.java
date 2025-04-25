import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] dp;
    static int N;
    static int result = -(int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                result = Math.max(map[i][j], result);
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 1; i < N - k + 1; i++) {
                for (int j = 1; j < N - k + 1; j++) {
                    int sum = dp[i + k][j + k] - dp[i - 1][j + k] - dp[i + k][j - 1] + dp[i - 1][j - 1];
                    result = Math.max(sum, result);
                }
            }
        }

        System.out.println(result);
    }

    public static void print(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                sb.append(map[i][j]).append("\t");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}