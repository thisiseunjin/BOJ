import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static char[][] map;
    static boolean[][] isVisited;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String info = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = info.charAt(j);
            }
        }

        int rgb = 0;
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j]) continue;
                rgb++;
                RGB(map[i][j], i, j);
            }
        }

        int rb = 0;
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j]) continue;
                rb++;
                RB(map[i][j], i, j);
            }
        }


        System.out.println(rgb + " " + rb);
    }

    public static void RB(char color, int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        isVisited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (!inRange(nx, ny)) continue;
                if (isVisited[nx][ny]) continue;

                if ((color == 'G' || color == 'R') && map[nx][ny] == 'B') continue;
                if (color == 'B' && map[nx][ny] != 'B') continue;
                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static void RGB(char color, int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        isVisited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (!inRange(nx, ny)) continue;
                if (map[nx][ny] != color) continue;
                if (isVisited[nx][ny]) continue;
                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}