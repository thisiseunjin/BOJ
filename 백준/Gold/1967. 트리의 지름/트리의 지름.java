import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result = 0;
    static ArrayList<int[]>[] info;
    static boolean[] isSelected;
    static int[] memo;
    static int maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        info = new ArrayList[N + 1];
        isSelected = new boolean[N + 1];
        memo = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            info[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            info[v1].add(new int[]{v2, adj});
            info[v2].add(new int[]{v1, adj});
        }
        isSelected[1] = true;
        dfs(1, 0);
        isSelected = new boolean[N + 1];
        result = 0;
        isSelected[maxNode] = true;
        dfs(maxNode, 0);
        System.out.println(result);
    }

    public static void dfs(int v, int dist) {
//        System.out.printf("v = %d, dist = %d\n", v, dist);
        if (dist > result) {
            maxNode = v;
            result = dist;
        }

        //연결된 곳을 탐색 한다.
        for (int[] next : info[v]) {
            if (isSelected[next[0]]) continue;
            isSelected[next[0]] = true;
            dfs(next[0], dist + next[1]);
//            isSelected[next[0]] = false;
        }
    }


}