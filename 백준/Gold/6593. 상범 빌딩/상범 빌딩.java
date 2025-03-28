import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int L, R, C;
    static char[][][] map;
    static boolean[][][] isVisited;
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            isVisited = new boolean[L][R][C];
            q.clear();

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = str.charAt(k);
                        if (map[i][j][k] == 'S') {
                            isVisited[i][j][k] = true;
                            q.add(new int[]{i, j, k, 0});
                        }
                    }
                }
                br.readLine();
            }

            int res = bfs();
            if (res == -1) {
                sb.append("Trapped!").append("\n");
            } else {
                sb.append("Escaped in " + res + " minute(s).\n");
            }
        }

        System.out.println(sb);
    }

    public static int bfs() {
        int time = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int x = cur[1];
            int y = cur[2];
            int t = cur[3];


            if (map[z][x][y] == 'E') return t;

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!inRange(nz, nx, ny)) continue;
                if (isVisited[nz][nx][ny]) continue;
                if (map[nz][nx][ny] == '#') continue;

                isVisited[nz][nx][ny] = true;
                q.add(new int[]{nz, nx, ny, t + 1});
            }
        }


        return time;
    }

    public static boolean inRange(int z, int x, int y) {
        return z >= 0 && x >= 0 && y >= 0 && z < L && x < R && y < C;
    }
}