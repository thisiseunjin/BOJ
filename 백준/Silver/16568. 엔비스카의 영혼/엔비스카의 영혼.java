import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int a;
    static int b;
    static int result = 0;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        result = N;
        isVisited = new boolean[N + 1];

        bfs();

        System.out.println(result);
    }

    public static void bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N, 0});
        isVisited[N] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int hp = cur[0];
            int time = cur[1];

            if (cur[0] == 0) {
                result = Math.min(N, cur[1]);
                break;
            }
            // 1 감소
            if (hp - 1 >= 0 && !isVisited[hp - 1]) {
                isVisited[hp - 1] = true;
                q.add(new int[]{hp - 1, time + 1});
            }
            // a+1 감소
            if (hp - (a + 1) >= 0 && !isVisited[hp - (a + 1)]) {
                isVisited[hp - (a + 1)] = true;
                q.add(new int[]{hp - (a + 1), time + 1});
            }
            // b+1 감소
            if (hp - (b + 1) >= 0 && !isVisited[hp - (b + 1)]) {
                isVisited[hp - (b + 1)] = true;
                q.add(new int[]{hp - (b + 1), time + 1});
            }


        }
    }

}