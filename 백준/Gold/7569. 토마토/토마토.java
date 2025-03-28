import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static int N, M, H;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        q.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        bfs();

        System.out.println(isEnd() ? result : -1);

    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int x = cur[1];
            int y = cur[2];
            int time = cur[3];

            result = Math.max(time, result);

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!inRange(nz, nx, ny)) continue;
                if (map[nz][nx][ny] != 0) continue;

                map[nz][nx][ny] = 1;
                q.add(new int[]{nz, nx, ny, time + 1});
            }
        }
    }

    public static boolean isEnd() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) return false;
                }
            }
        }

        return true;
    }

    public static boolean inRange(int h, int x, int y) {
        return h >= 0 && x >= 0 && y >= 0 && h < H && x < N && y < M;
    }
}