import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;   //인출할 횟수
    static int N;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        int right = 0;

        for (int i = 0; i < N; i++) {
            int m = Integer.parseInt(br.readLine());
            money[i] = m;
            right += m;
        }
        int result = right;
        int left = 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                right = mid - 1;
                result = Math.min(result, mid);
            } else {
                left = mid + 1;
            }

        }

        System.out.println(result);


    }

    public static boolean isPossible(int m) {
        int cnt = 1;
        int have = m;

        for (int i = 0; i < N; i++) {
            //지금 돈으로 사용할 수 없다?
            if (money[i] > have) {
                cnt++;
                have = m;
            }

            have -= money[i];
            if (have < 0) return false;

            if (cnt > M) return false;
        }

        return cnt <= M;
    }
}