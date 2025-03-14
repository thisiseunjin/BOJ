import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V;   //정점의 개수
    static int E;   //간선의 개수
    static int startV;
    static ArrayList<int[]>[] list;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(br.readLine());
        dp = new int[V + 1];
        Arrays.fill(dp, (int) 1e9);

        list = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            list[v1].add(new int[]{v2, adj});
        }

        dijkstra(startV);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            sb.append(dp[i] == (int) 1e9 ? "INF" : dp[i]);
            sb.append("\n");
        }
        System.out.print(sb);
//        System.out.println(Arrays.toString(dp));
    }

    public static void dijkstra(int v) {

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(ints -> ints[1]));
        dp[v] = 0;
        q.add(new int[]{v, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (dp[cur[0]] < cur[1]) continue;

            //갈 수 있는 곳을 순회한다.
            for (int[] next : list[cur[0]]) {
                //갈수 있다? -> 나 보다 dp값이 작은 경우만 갈 수 있다.
                if (next[1] + cur[1] >= dp[next[0]]) continue;
                dp[next[0]] = next[1] + cur[1];
                q.add(new int[]{next[0], cur[1] + next[1]});
            }
        }
    }
}