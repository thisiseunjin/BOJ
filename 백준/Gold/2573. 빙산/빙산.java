import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    static int M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] isSelelcted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        while (true) {

            time++;
            melting();
            int cnt = counting();
            if (cnt >= 2) break;
            if (isAllMelted()) {
                time = 0;
                break;
            }
        }

        System.out.println(time);


    }

    public static int counting() {
        int count = 0;
        isSelelcted = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] <= 0) continue;
                if (isSelelcted[i][j]) continue;
                bfs(i, j);
                count++;
            }
        }

        return count;
    }

    public static void melting() {
        //녹는 작업 진행
        ArrayDeque<int[]> q = new ArrayDeque<>();
        //0: x좌표, 1: y좌표, 2: 녹아야 하는 값.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] <= 0) continue;   //이미 다 녹아 있다면 안녹는다.
                int adj = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (!inRange(nx, ny)) continue;
                    if (map[nx][ny] > 0) continue;
                    adj++;
                }

                q.add(new int[]{i, j, adj});
            }
        }

        //이제 녹아야할 점들이 녹는다.
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int adh = cur[2];
            map[x][y] -= adh;
        }
//        System.out.println("==========================");
//        print();
//        System.out.println("==========================");

    }

    public static boolean isAllMelted() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] <= 0) continue;
                return false;
            }
        }

        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        isSelelcted[i][j] = true;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (!inRange(nx, ny)) continue;
                if (isSelelcted[nx][ny]) continue;
                if (map[nx][ny] <= 0) continue;

                isSelelcted[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }
}