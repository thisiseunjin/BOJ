import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    static int[] start;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new int[]{i, j, 0};
                }
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j] == 0 ? 0 : dp[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);


    }

    public static void bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(start);
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        dp[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
//            System.out.println(Arrays.toString(cur));

            //갈 수 있는 곳을 간다.
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

//                System.out.printf("(%d, %d)\n", nx, ny);

                if (!inRange(nx, ny)) {
//                    System.out.println("범위 오류");
                    continue; //범위를 벗어난다.
                }
                if (dp[nx][ny] > -1) {
//                    System.out.println("방문 체크 오류");
                    continue; //이미 방문했다.
                }
                if (map[nx][ny] == 0) {
//                    System.out.println("갈 수 없는 곳 판단 오류");
                    continue;
                }
                dp[nx][ny] = cur[2] + 1;
                q.add(new int[]{nx, ny, dp[nx][ny]});
            }
        }

    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= N - 1 && y <= M - 1;
    }
}