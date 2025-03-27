import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int K;
    static boolean[][] isSelected;
    static int[][] map;
    static ArrayList<Integer> list = new ArrayList<>();
    static int count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        isSelected = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            draw(x1, y1, x2, y2);
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isSelected[i][j]) continue;
                if (map[i][j] == 1) continue;
                int cnt = bfs(i, j);
                count++;
                list.add(cnt);
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for (int n : list) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }

    public static int bfs(int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int size = 0;
        isSelected[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!inRange(nx, ny)) continue;
                if (map[nx][ny] == 1) continue;
                if (isSelected[nx][ny]) continue;

                isSelected[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return size;
    }


    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    public static void draw(int y1, int x1, int y2, int x2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                map[i][j] = 1;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}