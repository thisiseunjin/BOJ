import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] isSelected;
    static int[][] info;
    static int result = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N];
        info = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            info[i][0] = s;
            info[i][1] = b;
        }

        comb(0, 0);
        System.out.println(result);

    }

    public static void comb(int cnt, int start) {
        result = Math.min(result, calc());
        if (cnt == N) {
            return;
        }

        for (int i = start; i < N; i++) {
            isSelected[i] = true;
            comb(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    public static int calc() {
        int totalS = 1; //신맛은 곱이고
        int totalB = 0; //쓴맛은 합이다.

        int cnt = 0;//지금까지 내가 선택한 값이 몇개인가?
        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) continue;
            cnt++;
            totalS *= info[i][0];
            totalB += info[i][1];
        }

        return cnt == 0 ? 1_000_000_000 : Math.abs(totalB - totalS);
    }
}