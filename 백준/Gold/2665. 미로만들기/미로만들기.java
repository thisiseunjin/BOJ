import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        result = N * N;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(result);

    }

    public static void bfs() {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 0, map[0][0] == 1 ? 0 : 1));
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == N - 1 && cur.y == N - 1) {
                result = Math.min(cur.adj, result);
                break;
            }

            //지금 갈 수 있는 곳에서 4방 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!inRange(nx, ny)) continue;
                if (isVisited[nx][ny]) continue;

                isVisited[nx][ny] = true;
                q.add(new Point(nx, ny, map[nx][ny] == 1 ? cur.adj : cur.adj + 1));
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;
        int adj;

        public Point(int x, int y, int adj) {
            this.x = x;
            this.y = y;
            this.adj = adj;
        }

        public int compareTo(Point p) {
            return this.adj - p.adj;
        }
    }
}