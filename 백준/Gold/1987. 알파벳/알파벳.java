import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static boolean[] isSelected = new boolean[26];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        isVisited[0][0] = true;
        isSelected[map[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(result);

    }

    public static void dfs(int x, int y, int cnt) {
        result = Math.max(result, cnt);

        //갈 수 있는 곳을 간다.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny)) continue;
            if (isVisited[nx][ny]) continue;
            if (isSelected[map[nx][ny]]) continue;

            isVisited[nx][ny] = true;
            isSelected[map[nx][ny]] = true;
            dfs(nx, ny, cnt + 1);
            isVisited[nx][ny] = false;
            isSelected[map[nx][ny]] = false;
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}