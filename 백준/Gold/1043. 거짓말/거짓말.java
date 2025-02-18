import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;  //사람의 수
    static int M;  //파티의 수
    static int[] parents;   //부모: 파티의 번호(작은 것이 우선)으로 저장될 예정임.
    static boolean[] isKnow;
    static int[] knowPeople;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //초기화, 처음 자신은 본인이 주인임.
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
        isKnow = new boolean[N + 1];

        list = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        knowPeople = new int[K];
        for (int i = 0; i < K; i++) {
            int idx = Integer.parseInt(st.nextToken());
            isKnow[idx] = true;
            knowPeople[i] = idx;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) continue;
            for (int j = 0; j < n; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < M; i++) {
            int first = list[i].get(0);
            for (int j = 1; j < list[i].size(); j++) {
                union(first, list[i].get(j));
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int first = list[i].get(0);
            boolean flag = true;

            for (int j = 0; j < K; j++) {
                if (find(first) == find(knowPeople[j])) {
                    flag = false;
                    break;
                }
            }

            if (flag) cnt++;
        }

        System.out.println(cnt);

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        parents[b] = a;
    }

    public static int find(int x) {
        int px = parents[x];
        if (px == x) return x;

        return parents[x] = find(px);
    }

}