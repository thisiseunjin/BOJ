import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] info = new int[100_000];
    static boolean[] isSelected;
    static boolean[] isDone;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {

            N = Integer.parseInt(br.readLine());
            isSelected = new boolean[N];
            info = new int[N];
            isDone = new boolean[N];
            cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken()) - 1;
                info[i] = n;
            }

            for (int i = 0; i < N; i++) {
                if (isSelected[i]) continue;
                dfs(i);
            }
            sb.append(N - cnt).append("\n");
        }

        System.out.print(sb);
    }


    public static void dfs(int v) {
        isSelected[v] = true;
        int next = info[v];

        if (!isSelected[next]) {
            dfs(next);
        } else if (!isDone[next]) {
            for (int i = next; i != v; i = info[i]) {
                cnt++;
            }
            cnt++;
        }
        isDone[v] = true;
    }
}