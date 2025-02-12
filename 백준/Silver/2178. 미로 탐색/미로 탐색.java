
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int result = (int) 1e9;
    static int[][] map;
    static int N;
    static int M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        result = bfs();

        System.out.println(result);

    }

    public static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        map[0][0] = 2;
        q.add(new int[]{0, 0, 1});
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int depth = cur[2];

            if (x == N - 1 && y == M - 1) {
                cnt = depth;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (!inRange(nx, ny)) continue;
                if (map[nx][ny] != 1) continue;
                map[nx][ny] = 2;

                q.add(new int[]{nx, ny, depth + 1});
            }
        }

        return cnt;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= N - 1 && y <= M - 1;
    }
}