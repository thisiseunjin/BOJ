import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int T;
    static int[][] memo = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(combination(n, r));
        }

    }

    public static int combination(int n, int r) {
        if (memo[n][r] > 0) return memo[n][r];

        if (n == r || r == 0) {
            return memo[n][r] = 1;
        }
        return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}