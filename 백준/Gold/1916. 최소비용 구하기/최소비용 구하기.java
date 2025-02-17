import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;   // 도시의 개수
    static int M;   // 버스의 개수
    static ArrayList<int[]>[] list;
    static int start;
    static int end;
    static int result = (int) 1e9;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        dp = new int[N + 1];
        Arrays.fill(dp, (int) 1e9);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            list[v1].add(new int[]{v2, adj});
//            list[v2].add(new int[]{v1, adj});
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(dp[end]);
    }

    public static void dijkstra() {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(arr -> arr[1]));
        dp[start] = 0;
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (dp[cur[0]] < cur[1]) continue;

            for (int i = 0; i < list[cur[0]].size(); i++) {
                int[] next = list[cur[0]].get(i);
                int v = next[0];
                int adj = next[1];

                if (dp[v] <= adj + cur[1]) continue;
                dp[v] = adj + cur[1];
                q.add(new int[]{v, dp[v]});
            }
        }
    }


}