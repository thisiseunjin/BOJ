import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static int N;
    static int M;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        isSelected = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        int result = bfs();

        System.out.println(result-1);
    }

    public static int bfs() {
        int cnt = 0;
        isSelected[1] = true;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;

            //연결된 부분을 감염시킨다.
            for (int next : list[cur]) {
                if (isSelected[next]) continue;
                isSelected[next] = true;
                q.add(next);
            }

        }

        return cnt;
    }
}