import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] parents;
    static boolean[] isVisited;
    //    static boolean[][] edge;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        isVisited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        isVisited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int v = cur[0];
            int p = cur[1];

            parents[v] = p;

            for (int i = 0; i < list[v].size(); i++) {
                int next = list[v].get(i);
                if (isVisited[next]) continue;

                //간다
                isVisited[next] = true;
                q.add(new int[]{next, v});

            }
        }
    }
}