import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] isSelected;
    static int N;
    static boolean[][] relationship;
    static ArrayList<Integer> list;
    static int min = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        relationship = new boolean[N + 1][N + 1];
        list = new ArrayList<>();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            if (v1 == -1 && v2 == -1) break;

            relationship[v1][v2] = true;
            relationship[v2][v1] = true;
        }


        for (int i = 1; i < N + 1; i++) {
            int n = bfs(i);
            if (n == min) {
                list.add(i);
            } else if (n < min) {
                min = n;
                list.clear();
                list.add(i);
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }

        System.out.println(sb);
    }

    public static int bfs(int n) {
        int max = 0;
        isSelected = new boolean[N + 1];
        isSelected[n] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int depth = cur[1];
            max = Math.max(max, depth);

            //내가 갈 수 있는 곳을 간다.
            for (int i = 1; i < N + 1; i++) {
                if (!relationship[idx][i]) continue;
                if (isSelected[i]) continue;

                isSelected[i] = true;
                q.add(new int[]{i, depth + 1});
            }
        }

        if (!isPossible()) return (int) 1e9;
        return max;
    }

    public static boolean isPossible() {
        for (int i = 1; i < N + 1; i++) {
            if (!isSelected[i]) return false;
        }

        return true;
    }
}