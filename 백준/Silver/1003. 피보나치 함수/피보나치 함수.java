import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int zeroCount = 0;
    static int oneCount = 0;
    static int[] zeroMemo = new int[41];
    static int[] oneMemo = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(zeroMemo, -1);
        Arrays.fill(oneMemo, -1);

        zeroMemo[0] = 1;
        zeroMemo[1] = 0;
        oneMemo[0] = 0;
        oneMemo[1] = 1;

        for (int i = 2; i < 41; i++) {
            zeroMemo[i] = zeroMemo[i - 1] + zeroMemo[i - 2];
            oneMemo[i] = oneMemo[i - 1] + oneMemo[i - 2];
        }
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(zeroMemo[n]).append(" ").append(oneMemo[n]).append("\n");
        }

        System.out.println(sb);
    }

    public static void fibonacci(int n) {
        if (zeroMemo[n] != -1) return;


    }
}