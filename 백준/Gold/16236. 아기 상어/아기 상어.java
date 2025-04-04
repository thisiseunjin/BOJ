import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] isVisited;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int ateFishCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        int size = 2;
        while (true) {
            int[] res = bfs(startX, startY, size);
            if (res == null) break;
//            System.out.println(Arrays.toString(res));

            startX = res[0];
            startY = res[1];
            ateFishCount++;
            if (ateFishCount == size) {
                ateFishCount = 0;
                size++;
            }
            time += res[2];
            map[startX][startY] = 0;
        }

        System.out.println(time);
    }

    public static int[] bfs(int startX, int startY, int size) {
        isVisited = new boolean[N][N];
//        ArrayDeque<int[]> q = new ArrayDeque<>();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing((int[] value) -> value[2])
                .thenComparing(value -> value[0])
                .thenComparing(value -> value[1]));
        isVisited[startX][startY] = true;

        q.add(new int[]{startX, startY, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int depth = cur[2];

            if (map[cx][cy] != 9 && map[cx][cy] < size && map[cx][cy] > 0) {
                return new int[]{cx, cy, depth};
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!inRange(nx, ny)) continue;
                if (isVisited[nx][ny]) continue;
                if (map[nx][ny] > size) continue;
                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny, depth + 1});

            }
        }


        return null;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}