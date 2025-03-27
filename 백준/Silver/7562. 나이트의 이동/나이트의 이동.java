import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {2, 2, 1, -1, -2, -1, -2, 1};
    static int[] dy = {-1, 1, 2, 2, 1, -2, -1, -2};
    static int T;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            isSelected = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(startX, startY, endX, endY));
        }
    }

    public static int bfs(int startX, int startY, int endX, int endY) {
        int result = (int) 1e9;
        isSelected[startX][startY] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int adj = cur[2];

            if (cx == endX && cy == endY) {
                return adj;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (!inRange(nx, ny)) continue;
                if (isSelected[nx][ny]) continue;
                isSelected[nx][ny] = true;
                q.add(new int[]{nx, ny, adj + 1});
            }
        }

        return result;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}