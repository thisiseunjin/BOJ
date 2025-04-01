import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] dp2;
    static int V1, V2;
    static int N, E;
    static ArrayList<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        dp2 = new int[N + 1];


        Arrays.fill(dp2, (int) 1e9);

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            list[v1].add(new int[]{v2, adj});
            list[v2].add(new int[]{v1, adj});
        }
        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());


        dijkstra(1, N);
        int startToV1 = dp[V1];
        int startToV2 = dp[V2];

        dijkstra(V1, N);
        int V1ToV2 = dp[V2];
        int V1ToN = dp[N];

        dijkstra(V2, N);
        int V2toV1 = dp[V1];
        int V2toN = dp[N];


        int route1 = (int) 1e9;
        int route2 = (int) 1e9;

        if(startToV1<(int)1e9 && V1ToV2<(int)1e9 && V2toN<(int)1e9){
            route1 = startToV1+V1ToV2+V2toN;
        }
        if(startToV2<(int)1e9 && V2toV1<(int)1e9 && V1ToN<(int)1e9){
            route2 = startToV2+V2toV1+V1ToN;
        }

        int min = Math.min(route1, route2);


        System.out.println(min >= (int) 1e9 ? -1 : min);

    }

    public static void dijkstra(int start, int end) {
        dp = new int[N + 1];
        Arrays.fill(dp, (int) 1e9);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dp[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
//            if (cur == end) continue;

            //갈 수 있는 곳을 간다.
            for (int[] next : list[cur]) {
                int nx = next[0];
                int adj = next[1];

                if (dp[nx] < dp[cur] + adj) continue;
                dp[nx] = dp[cur] + adj;
                q.add(nx);
            }
        }
    }

}