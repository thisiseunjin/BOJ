import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    //    static int count;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] map;
    static boolean[][] isSelected;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        isSelected = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                int status = input.charAt(j) - '0';
                map[i][j] = status == 1;
            }
        }
        int totalCount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j]) continue;
                if (isSelected[i][j]) continue;
                totalCount++;
                list.add(bfs(i, j));
            }
        }
        Collections.sort(list);

        sb.append(totalCount).append("\n");
        for (int n : list) {
            sb.append(n).append("\n");
        }

        System.out.print(sb);
    }

    public static int bfs(int x, int y) {
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        isSelected[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                if (!map[nx][ny]) continue;
                if (isSelected[nx][ny]) continue;

                isSelected[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        return count;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}