import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int V;
    static StringBuilder sb;
    static boolean[][] edge;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        edge = new boolean[N + 1][N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            edge[v1][v2] = true;
            edge[v2][v1] = true;
        }

        for (int i = 1; i < N + 1; i++) {
            edge[i][i] = true;
        }

        isVisited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        isVisited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);

    }

    static void dfs(int v) {
        isVisited[v] = true;
        sb.append(v).append(" ");
        for (int i = 1; i < N + 1; i++) {
            if (!edge[v][i]) continue;
            if (isVisited[i]) continue;
            if (v == i) continue;

            dfs(i);
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        isVisited[v] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int i = 1; i < N + 1; i++) {
                if (!edge[cur][i]) continue;
                if (i == v) continue;
                if (isVisited[i]) continue;

                isVisited[i] = true;
                q.add(i);
            }
        }
    }
}