import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] T;
    static int[] P;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        counsel(0, 0);

        System.out.println(result);

    }

    static void counsel(int day, int sum) {
        if (day >= N) {
            result = Math.max(result, sum);
            return;
        }

        if (day + T[day] <= N) {
            counsel(day + T[day], sum + P[day]);
        }

        counsel(day + 1, sum);
    }
}