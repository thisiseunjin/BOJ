import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents;
    static int[] dp;
    static ArrayList<int[]>[] list;
    static int N;
    static int M;
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        parents = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dp, (int) 1e9);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            list[v1].add(new int[]{v2, adj});
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        StringBuilder sb = new StringBuilder();
        sb.append(dp[end]).append("\n");

        Stack<Integer> stack = new Stack<>();
        int cur = end;
        while (true) {
            stack.push(cur);
            if (cur == start) break;
            cur = parents[cur];
        }

        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.print(sb);
    }

    public static void dijkstra(int start, int end) {
        dp[start] = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int adj = cur[1];
            if(dp[cx]<adj) continue;
//            if (dp[cx] <= adj) continue;
            //갈 수 있는 곳을 간다.
            for (int[] next : list[cx]) {
                int nx = next[0];
                int nextAdj = adj + next[1];

                if (dp[nx] <= nextAdj) continue;
                dp[nx] = nextAdj;
                parents[nx] = cx;
                q.add(new int[]{nx, nextAdj});
            }
        }


    }
}