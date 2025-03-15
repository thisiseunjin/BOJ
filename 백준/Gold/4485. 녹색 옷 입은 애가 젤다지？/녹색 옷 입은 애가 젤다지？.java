import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], (int) 1e9);
            }
            dijkstra();
            sb.append("Problem ").append(test++).append(": ").append(dp[N - 1][N - 1]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dijkstra() {
        // 4방 탐색 시작
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(ints -> ints[2]));
        //시작 지점은 (0,0) -> (N-1, N-1) 지점까지 이동 해야함.
        dp[0][0] = map[0][0];
        q.add(new int[]{0, 0, dp[0][0]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int adj = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!inRange(nx, ny)) continue;   //범위를 넘어갔다?
                if (dp[nx][ny] <= adj + map[nx][ny]) continue;  //거기를 가는게 최선이 아니다!
                dp[nx][ny] = adj + map[nx][ny];
                q.add(new int[]{nx, ny, adj + map[nx][ny]});
            }
        }

    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= N - 1 && y <= N - 1;
    }
}