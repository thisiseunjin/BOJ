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
            }
        }

        for (int depth = 0; depth <= maxDepth; depth++) {
            isVisited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isVisited[i][j]) continue;
                    if (map[i][j] <= depth) continue;
                    cnt++;
                    dfs(i, j, depth);
                }
            }
//            System.out.println(depth + " : " + cnt);
            result = Math.max(cnt, result);
        }

        System.out.println(result);


    }

    public static boolean dfs(int x, int y, int depth) {
        Stack<int[]> stack = new Stack<>();

        //방문 체크 하고 넣는다!
        isVisited[x][y] = true;
        int cnt = 0;
        stack.push(new int[]{x, y});

        while (!stack.isEmpty()) {
            cnt++;
            int[] cur = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                if (isVisited[nx][ny]) continue;
                if (map[nx][ny] <= depth) continue;
                isVisited[nx][ny] = true;
                stack.push(new int[]{nx, ny});
            }
        }

        return cnt > 0;
    }

    public static boolean inRange(int x, int y) {
        if (x > N - 1 || y > N - 1 || x < 0 || y < 0) return false;
        return true;
    }
}