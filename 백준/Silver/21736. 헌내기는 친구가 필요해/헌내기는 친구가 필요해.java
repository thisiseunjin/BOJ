import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] isVisited;
    static int result = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[N][M];
        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        System.out.println(result == 0 ? "TT" : result);
    }

    public static void bfs(int startX, int startY) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (map[cx][cy] == 'P') result++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!inRange(nx, ny)) continue;
                if (isVisited[nx][ny]) continue;
                if (map[nx][ny] == 'X') continue;

                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= N - 1 && y <= M - 1;
    }
}