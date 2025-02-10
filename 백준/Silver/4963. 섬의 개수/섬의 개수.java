import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;
    static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static StringBuilder sb = new StringBuilder();
    static int result = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            result = 0;
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] != 1) continue;
                    bfs(i, j);
                    result++;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        map[x][y] = 2;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!inRange(nx, ny)) continue;
                if (map[nx][ny] != 1) continue;
                map[nx][ny] = 2;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= h - 1 && y <= w - 1;
    }
}