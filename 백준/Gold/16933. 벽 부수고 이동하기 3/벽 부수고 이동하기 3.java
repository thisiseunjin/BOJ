import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int day = 0;
    static int time = 0;    //time이 짝수일 경우는 낮이다.
    static boolean[][][] isSelected;
    static int[][] map;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isSelected = new boolean[K + 1][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        isSelected[0][0][0] = true;
        q.add(new int[]{0, 0, 0, 1});
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int k = cur[2];
            int day = cur[3];


//            System.out.printf("(%d,%d), 움직인 횟수 : %d, day = %d\n", x, y, k, day);

            if (x == N - 1 && y == M - 1) {
                return day;
            }

            //갈수 있는 곳을 간다.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!inRange(nx, ny)) continue;
                // 벽 부수기 로직 일부 수정
                if (map[nx][ny] == 1 && k + 1 <= K && !isSelected[k + 1][nx][ny]) {

                    //지금이 낮이다? 그럼 부수고 그냥 이동, 지금이 밤이다? 낮에 부셔야 하기 때문
                    if (day % 2 == 1) {
                        isSelected[k + 1][nx][ny] = true;
                        q.add(new int[]{nx, ny, k + 1, day + 1});
                    } else {
                        q.add(new int[]{x, y, k, day + 1});
                    }

                }

                if (map[nx][ny] == 0) {
                    if (isSelected[k][nx][ny]) continue;
                    isSelected[k][nx][ny] = true;
                    q.add(new int[]{nx, ny, k, day + 1});
                }
            }

        }
        return -1;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}