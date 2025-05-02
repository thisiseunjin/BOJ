import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] result = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(N, 0, 0);
        System.out.printf("%d\n%d", result[0], result[1]);

    }

    public static void div(int size, int startX, int startY) {
        int cur = map[startX][startY];
        boolean isPossible = true;
        for (int i = startX; i < startX + size; i++) {
            if (!isPossible) break;
            for (int j = startY; j < startY + size; j++) {
                if (map[i][j] != cur) {
                    isPossible = false;
                    break;
                }
            }
        }

        if (isPossible) {
            result[cur]++;
            return;
        }

        //불가능할 경우
        div(size / 2, startX, startY);
        div(size / 2, startX + size / 2, startY);
        div(size / 2, startX, startY + size / 2);
        div(size / 2, startX + size / 2, startY + size / 2);
    }
}