import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int[][] stores;
    static boolean[] isVisited;
    static int sx, sy;
    static int fx, fy;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            stores = new int[N][2];
            isVisited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                stores[i][0] = Integer.parseInt(st.nextToken());
                stores[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());

            sb.append(bfs() ? "happy" : "sad").append("\n");
        }
        System.out.println(sb);
    }

    public static boolean bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            //종료 조건
            int dist = getDist(cx, cy, fx, fy);
//            System.out.printf("(%d, %d)에서 페스티벌까지 %dm걸림\n", cx, cy, dist);
            if (dist <= 1_000) {
                return true;
            }

            //편의점 들릴 수 있는 곳이 있다면? 간다.
            for (int i = 0; i < N; i++) {
                if (isVisited[i]) continue;
                int nx = stores[i][0];
                int ny = stores[i][1];
                int d = getDist(cx, cy, nx, ny);
                if (d > 1_000) {
//                    System.out.printf("(%d, %d)에서 다음 편의점까지(%d,%d) %dm걸림\n", cx, cy, nx, ny, d);
                    continue;
                }

                isVisited[i] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return false;
    }

    public static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}