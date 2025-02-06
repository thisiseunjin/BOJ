import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] adj;
    static int N;
    static boolean[] isVisited;
    static int result = (int) 1e9;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        selected = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            isVisited = new boolean[N];
            isVisited[i] = true;
            dfs(i, 0, 0, i);
        }

        System.out.println(result);
    }

    public static void dfs(int v, int sum, int cnt, int start) {

        if (sum >= result) return;
        selected[cnt] = v;

        boolean hasNext = false;
        //내가 갈 수 있는 곳을 간다.
        for (int i = 0; i < N; i++) {
            if (adj[v][i] == 0) continue;
            if (isVisited[i]) continue;

            hasNext = true;
            isVisited[i] = true;
            dfs(i, sum + adj[v][i], cnt + 1, start);
            isVisited[i] = false;
        }

        if (!hasNext && isDone() && adj[v][start] > 0) {
            result = Math.min(result, sum + adj[v][start]);
        }

    }

    public static boolean isDone() {
        for (boolean flag : isVisited) {
            if (!flag) return false;
        }
        return true;
    }
}