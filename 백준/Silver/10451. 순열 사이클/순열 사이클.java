import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int[] isVisited;
    static int[] next;
    static StringBuilder sb = new StringBuilder();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            next = new int[N];
            isVisited = new int[N];
            result = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken()) - 1;
                next[i] = n;
            }

            int cnt = 1;
            for (int i = 0; i < N; i++) {
                if (isVisited[i] > 0) continue;
                check(i, cnt++);
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    public static void check(int start, int cnt) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        isVisited[start] = cnt;

        while (!q.isEmpty()) {
            int v = q.poll();
            int n = next[v];

            if (isVisited[n] == cnt) {
                result++;
                break;
            }

            isVisited[n] = cnt;
            check(n, cnt);
        }

    }

}