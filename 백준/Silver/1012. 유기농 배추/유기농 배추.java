import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int M;
    static int N;
    static int K;
    static boolean[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[M][N];
            isVisited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());

                map[m][n] = true;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!map[i][j]) continue;
                    if (isVisited[i][j]) continue;

                    cnt++;
                    dfs(i, j);
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int x, int y) {
        //해당 시작 점에서 dfs를 진행 한다.
        Deque<int[]> stack = new ArrayDeque<>();
        isVisited[x][y] = true;
        stack.addFirst(new int[]{x, y});

        while (!stack.isEmpty()) {
            int[] cur = stack.pollFirst();
            int cx = cur[0];
            int cy = cur[1];

            //갈 수 있는 곳을 간다.
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!inRange(nx, ny)) continue;
                if (isVisited[nx][ny]) continue;
                if (!map[nx][ny]) continue;

                isVisited[nx][ny] = true;
                stack.addFirst(new int[]{nx, ny});
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}