import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    //    static boolean[][][] isSelected;
    static boolean[][] isSelected;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? -1 : 0;
            }
        }

        isSelected = new boolean[N][N];

        int label = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                if (map[i][j] == -1) {
                    map[i][j] = label;
                    isSelected[i][j] = true;
                    labeling(label++, i, j);
                }
                if(!isPossible(i,j)) continue;
                install(i, j, map[i][j]);

            }
        }


        System.out.println(result);
    }

    public static void labeling(int label, int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny)) continue;
            if (isSelected[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;
            if (map[nx][ny] != -1) continue;
            isSelected[nx][ny] = true;
            map[nx][ny] = label;

            labeling(label, nx, ny);
        }
    }


    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= N - 1 && y <= N - 1;
    }

    public static void install(int startX, int startY, int label) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isSelected = new boolean[N][N];
        isSelected[startX][startY] = true;
        q.add(new int[]{startX, startY, 0});


        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int dist = p[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!inRange(nx, ny)) continue;
                if (isSelected[nx][ny]) continue;
                if (map[nx][ny] == label) continue;
                if (map[nx][ny] > 0) {
                    result = Math.min(result, dist);
                    continue;
                }

                isSelected[nx][ny] = true;
                q.add(new int[]{nx, ny, p[2] + 1});
            }
        }


    }

    public static boolean isPossible(int x, int y) {
        if (map[x][y] == 0) return false;
        //4방 탐색 주변이 하나라도 땅이면? 설치할 수 있다.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny)) continue;
            if (map[nx][ny] == 0) return true;
        }

        return false;
    }
}