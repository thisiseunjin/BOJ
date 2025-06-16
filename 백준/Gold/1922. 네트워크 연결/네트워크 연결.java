import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;   //컴퓨터의 수
    static int M;   //연결 할 수 있는 선의 수
    static ArrayList<int[]> list;
    static int[] parents;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new int[]{v1, v2, cost});
        }

        kruskal();

        System.out.println(result);


    }

    public static void kruskal() {
        int cnt = 0;
        Collections.sort(list, Comparator.comparing(ints -> ints[2]));
        for (int[] cur : list) {
            int v1 = cur[0];
            int v2 = cur[1];
            int cost = cur[2];

            if (find(v1) == find(v2)) continue;

            result += cost;
            union(v1, v2);
            cnt++;

            if (cnt == N - 1) return;
        }

    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;
        if (pb > pa) {
            parents[pb] = pa;
        } else {
            parents[pa] = pb;
        }
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

}