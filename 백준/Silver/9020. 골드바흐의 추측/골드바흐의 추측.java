import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int T;
    static ArrayList<Integer> decimal;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        decimal = new ArrayList<>();
        sb = new StringBuilder();

        for (int i = 2; i < 10_001; i++) {
            if (!isDecimal(i)) continue;
            decimal.add(i);
        }

        T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            int n = Integer.parseInt(br.readLine());
            int minDiff = (int) 1e9;
            int n1 = -1;
            int n2 = -1;
            for (int d : decimal) {
                if (!isDecimal(n - d)) continue;
                if (d >= n) break;
                int diff = Math.abs(d - (n - d));
                if (diff < minDiff) {
                    minDiff = diff;
                    n1 = d;
                    n2 = n - d;
                }

            }

            sb.append(n1).append(" ").append(n2).append("\n");
        }

        System.out.print(sb);
    }


    public static boolean isDecimal(int n) {
        if (n == 2) return true;

        for (int i = 2; i <= (n / 2) + 1; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}