import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] isVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(result == (int) 1e9 ? -1 : result);


    }

    public static void bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0, 1});
        isVisited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];
            int depth = cur[3];

            if (cx == N - 1 && cy == M - 1) {
                result = Math.min(depth, result);
                break;
            }

            //내가 갈 수 있는 곳을 간다.
            //벽을 부수지 않고 갈 수 있는 곳
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!inRange(nx, ny)) continue;
                if (isVisited[nx][ny][cnt]) continue;
                //내가 벽을 부술까?
                if (map[nx][ny] == 1) {
                    if (cnt > 0) continue; //이미 한번 부순 적이 있다면 부술 수 없다.
                    if (isVisited[nx][ny][cnt + 1]) continue;   //벽을 부셔서 이동한 이력이 있다면 중복 방지
                    isVisited[nx][ny][cnt + 1] = true;
                    q.add(new int[]{nx, ny, cnt + 1, depth + 1});
                    continue;
                }
                isVisited[nx][ny][cnt] = true;
                q.add(new int[]{nx, ny, cnt, depth + 1});

            }

        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= N - 1 && y <= M - 1;
    }
}