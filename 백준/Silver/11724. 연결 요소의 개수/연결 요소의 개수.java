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
    static boolean[] isSelected;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isSelected = new boolean[N];
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;

            list[v1].add(v2);
            list[v2].add(v1);
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            result++;
            bfs(i);
        }

        System.out.println(result);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        isSelected[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int v : list[cur]) {
                if (isSelected[v]) continue;
                isSelected[v] = true;
                q.add(v);
            }
        }
    }
}