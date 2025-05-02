import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] info;
    static boolean[] isSelected;
    static int N, M;
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new ArrayList[N];
        isSelected = new boolean[N];
        for (int i = 0; i < N; i++) {
            info[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            info[v1].add(v2);
            info[v2].add(v1);
        }

        for (int i = 0; i < N; i++) {
            if (isPossible) break;
            if (isSelected[i]) continue;
            isSelected[i] = true;
            dfs(i, 0);
            isSelected[i] = false;
        }

        System.out.println(isPossible ? 1 : 0);
    }

    public static void dfs(int v, int depth) {
        if (depth == 4) {
            isPossible = true;
            return;
        }

        isSelected[v] = true;

        for (int next : info[v]) {
            if (isSelected[next]) continue;
            isSelected[next] = true;
            dfs(next, depth + 1);
            isSelected[next] = false;
        }
    }

    public static boolean isAllSelected() {
        for (boolean bool : isSelected) {
            if (!bool) return false;
        }

        return true;
    }
}