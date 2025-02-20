import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] isRemoved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        isRemoved = new boolean[end + 1];
        isRemoved[1] = true;

        for (int i = start; i <= end; i++) {
            if (isRemoved[i]) continue;
            if (!isDecimal(i)) {
                remove(i, end);
                continue;
            }
            sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    public static boolean isDecimal(int n) {
        if (n == 1) return false;
        if (n == 2) return true;

        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void remove(int n, int max) {
        //n의 배수들을 모두 지워준다.
        int mul = 1;
        while (true) {
            int num = n * mul;
            if (num > max) break;

            isRemoved[num] = true;
            mul++;
        }
    }
}