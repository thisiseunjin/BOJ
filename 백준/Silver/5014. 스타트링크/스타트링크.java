import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        isVisited = new boolean[F + 1];
        int result = bfs(S);
        System.out.println(result == (int) 1e9 ? "use the stairs" : result);
    }

    public static int bfs(int x) {
        int result = (int) 1e9;

        isVisited[x] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
//        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[]{x, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int adj = cur[1];

            if (cx == G) return adj;

            if (inRange(cx + U) && !isVisited[cx + U]) {
                isVisited[cx + U] = true;
                q.add(new int[]{cx + U, adj + 1});
            }

            if (inRange(cx - D) && !isVisited[cx - D]) {
                isVisited[cx - D] = true;
                q.add(new int[]{cx - D, adj + 1});
            }
        }

        return result;
    }

    public static boolean inRange(int x) {
        return x > 0 && x <= F;
    }
}