import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] result;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        result = new int[3];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(N, 0, 0);

        System.out.printf("%d\n%d\n%d", result[0], result[1], result[2]);
    }

    public static void check(int size, int startX, int startY) {
        if (isAllSame(size, startX, startY)) {
            if (map[startX][startY] == -1) {
                result[0]++;
            } else if (map[startX][startY] == 0) {
                result[1]++;
            } else result[2]++;
            return;
        }

        //다시 쪼가르기~! 9등분으로 쪼갈라지기 시작함
        int halfSize = size / 3;
        check(halfSize, startX, startY);
        check(halfSize, startX, startY + halfSize);
        check(halfSize, startX, startY + (halfSize * 2));


        check(halfSize, startX + halfSize, startY);
        check(halfSize, startX + halfSize, startY + halfSize);
        check(halfSize, startX + halfSize, startY + (halfSize * 2));

        check(halfSize, startX + (halfSize * 2), startY);
        check(halfSize, startX + (halfSize * 2), startY + halfSize);
        check(halfSize, startX + (halfSize * 2), startY + (halfSize * 2));

    }

    public static boolean isAllSame(int size, int startX, int startY) {
        int color = map[startX][startY];
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (map[i][j] != color) return false;
            }
        }

        return true;
    }
}