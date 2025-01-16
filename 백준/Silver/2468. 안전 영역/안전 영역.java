import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int result = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxDepth = 0;
    static int minDepth = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxDepth = Math.max(map[i][j], maxDepth);
                minDepth = Math.min(map[i][j], minDepth);
            }
        }

        for (int depth = 0; depth <= maxDepth; depth++) {
            isVisited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isVisited[i][j]) continue;
                    if (map[i][j] <= depth) continue;
                    isVisited[i][j] = true;
                    DFS(depth, i, j);
                    cnt++;
                }
            }
            result = Math.max(cnt, result);
        }

        System.out.println(result);


    }

    public static void DFS(int depth, int x, int y) {

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!inRange(nx, ny)) continue;
            if (isVisited[nx][ny]) continue;
            if (map[nx][ny] <= depth) continue;

            isVisited[nx][ny] = true;
            DFS(depth, nx, ny);
        }
    }

    public static boolean inRange(int x, int y) {
        if (x > N - 1 || y > N - 1 || x < 0 || y < 0) return false;
        return true;
    }
}