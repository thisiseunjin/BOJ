import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static ArrayList<Integer>[] list;
    static boolean[] isVisited;
    static int[] order;
    static StringBuilder sb;
    static int depth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        isVisited = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list[v1].add(v2);
            list[v2].add(v1);
        }

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(list[i]);
        }

        dfs(R);


        sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);


    }

    public static void dfs(int v) {
        isVisited[v] = true;
        order[v] = ++depth;
        for (int next : list[v]) {
            if (isVisited[next]) continue;
            dfs(next);
        }
    }
}