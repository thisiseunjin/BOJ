import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int C;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int result = 0;
        int right = 1_000_000_000;
        int left = 0;
        int mid = (right + left) / 2;

        while (left <= right) {
            mid = (right + left) / 2;

            //가능 하다면? 거리를 늘려 본다.
            if (isPossible(mid)) {
                result = Math.max(mid, result);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    public static boolean isPossible(int dist) {
        int cnt = 1;
        int pre = houses[0];

        for (int i = 1; i < N; i++) {
            int d = houses[i] - pre;
            if (d < dist) continue;
            cnt++;
            pre = houses[i];

            if (cnt == C) break;
        }

        return cnt == C;
    }
}