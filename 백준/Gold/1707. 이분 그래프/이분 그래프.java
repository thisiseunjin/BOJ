import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static int V;
    static int E;
    static ArrayList<Integer>[] list;
    static int[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        for (int test = 0; test < K; test++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V + 1];
            for (int i = 0; i < V + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                list[v1].add(v2);
                list[v2].add(v1);
            }

            isVisited = new int[V + 1];
            Arrays.fill(isVisited, -1);
            boolean isPossible = true;
            for (int i = 1; i < V + 1; i++) {
                if (isVisited[i] != -1) continue;
                if (bfsCheck(i)) continue;
                isPossible = false;
                break;
            }

            sb.append(isPossible ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    public static boolean bfsCheck(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        isVisited[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int next : list[v]) {
                if (isVisited[next] != -1) {
                    if (isVisited[next] == isVisited[v]) return false;
                    continue;
                }
                isVisited[next] = isVisited[v] == 1 ? 0 : 1;
                q.add(next);
            }
        }

        return true;
    }
}