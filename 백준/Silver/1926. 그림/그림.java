import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M;
    static int maxSize = 0;
    static int cnt = 0;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;
                if (isVisited[i][j]) continue;
                cnt++;
                bfs(i, j);
            }
        }

        System.out.println(cnt + "\n" + maxSize);


    }

    public static void bfs(int startX, int startY) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY});
        int size = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            size++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!inRange(nx, ny)) continue;
                if (map[nx][ny] == 0) continue;
                if (isVisited[nx][ny]) continue;
                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny, size + 1});
            }
        }
        maxSize = Math.max(size, maxSize);

    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}