import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static ArrayList<int[]>[] list;
    static int[][] memo;
    static boolean[] isSelected;
    static int root = 0;
    static int maxDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            while (true) {
                int v2 = Integer.parseInt(st.nextToken());
                if (v2 == -1) break;
                int adj = Integer.parseInt(st.nextToken());
                list[v1].add(new int[]{v2, adj});
            }

        }
        isSelected = new boolean[V + 1];

//        memo = new int[V + 1][V + 1];
//        for (int i = 1; i < V + 1; i++) {
//            isSelected = new boolean[V + 1];
//            dfs(i, i, 0);
//        }

//        int result = 0;
//        for (int i = 1; i < V + 1; i++) {
//            result = Math.max(result, memo[i][root]);
//        }
        for (int i = 1; i < V + 1; i++) {
            dfs(i, 0);
        }
//        System.out.printf("root=%d, dist=%d", root, maxDist);
        maxDist = 0;
        isSelected = new boolean[V + 1];
        dfs(root, 0);

        System.out.println(maxDist);

    }

    public static void dfs(int v, int dist) {
        isSelected[v] = true;
//        memo[startV][v] = dist;

        if (dist > maxDist) {
            maxDist = dist;
            root = v;
        }

        for (int[] next : list[v]) {
            if (isSelected[next[0]]) continue;
            //갈 수 있는 곳이면? 간다.
            dfs(next[0], dist + next[1]);
        }
    }
}