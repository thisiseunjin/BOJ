import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, Integer> sizeInfo;
    static int[][] map;
    static int[][] memo;
    static int[][] result;
    static StringBuilder sb;
    static int N, M;
    static int[][] isVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        memo = new int[N][M];
        result = new int[N][M];
        isVisited = new int[N][M];  //방문하지 않은 곳은 0
        sizeInfo = new HashMap<>();
        sizeInfo.put(0, 0);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int label = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) continue;
                if (isVisited[i][j] != 0) continue;
                bfs(i, j, ++label);
            }
        }

        //라벨링 끝났고 이제 정답 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;
                calc(i, j);
            }
        }

        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }

    public static void calc(int x, int y) {
        boolean[] isSelected = new boolean[sizeInfo.size() + 1];
        int sum = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny)) continue;
            int key = isVisited[nx][ny];
            if (key == 0) continue;
            if (isSelected[key]) continue;
            isSelected[key] = true;
            sum += sizeInfo.get(key);
        }

        result[x][y] = sum;
    }

    public static void bfs(int startX, int startY, int label) {
        int size = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        isVisited[startX][startY] = label;
        q.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //범위
                if (!inRange(nx, ny)) continue;
                //방문 여부 확인
                if (isVisited[nx][ny] != 0) continue;
                //방문 가능 확인
                if (map[nx][ny] == 1) continue;

                isVisited[nx][ny] = label;
                q.add(new int[]{nx, ny});
            }
        }

        sizeInfo.put(label, size);

    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}