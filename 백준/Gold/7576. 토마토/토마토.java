import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] isVisited;
    static int left = 0;
    static Queue<int[]> q = new ArrayDeque<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];
        left = N * M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) left--;
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    isVisited[i][j] = true;
                }
            }
        }

        bfs();
        System.out.println(left==0?result:-1);


    }

    static void bfs() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int depth = cur[2];
            left--;

            result = Math.max(depth, result);

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (!inRange(nx, ny)) continue;
                if (isVisited[nx][ny]) continue;
                if (map[nx][ny] != 0) continue;

                map[nx][ny] = 1;
                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny, depth + 1});
            }
        }
    }


    static boolean inRange(int x, int y) {
        return x >= 0 && x <= N - 1 && y >= 0 && y <= M - 1;
    }
}