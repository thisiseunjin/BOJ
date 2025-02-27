import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static ArrayList<Integer>[] list;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        System.out.println(bfs(v1, v2));

    }

    public static int bfs(int from, int to) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{from, 0});
        isVisited[from] = true;

        while (!q.isEmpty()) {
            int[] v = q.poll();
            if (v[0] == to) {
                return v[1];
            }

            //갈 수 있는 곳을 간다
            for (int next : list[v[0]]) {
                if (isVisited[next]) continue;
                isVisited[next] = true;
                q.add(new int[]{next, v[1] + 1});
            }
        }

        return -1;
    }
}