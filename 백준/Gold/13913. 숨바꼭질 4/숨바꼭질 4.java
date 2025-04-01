import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static boolean[] isVisited;
    static int result = 0;
    static int[] parents;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isVisited = new boolean[100_001];
        parents = new int[100_001];

        bfs(N);
//        System.out.println(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");

        //경로 저장한 것 풀기
        Stack<Integer> stack = new Stack<>();
        int cur = K;
        while (true) {
            stack.push(cur);
            if (cur == N) {
                break;
            }
            cur = parents[cur];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.print(sb);

    }

    public static void bfs(int start) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        isVisited[start] = true;
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int time = cur[1];

            if (x == K) {
                result = time;
                break;
            }

            if (x * 2 <= 100_000 && !isVisited[x * 2]) {
                parents[x * 2] = x;
                isVisited[x * 2] = true;
                q.add(new int[]{x * 2, time + 1});
            }

            if (x + 1 <= 100_000 && !isVisited[x + 1]) {
                parents[x + 1] = x;
                isVisited[x + 1] = true;
                q.add(new int[]{x + 1, time + 1});
            }

            if (x - 1 >= 0 && !isVisited[x - 1]) {
                parents[x - 1] = x;
                isVisited[x - 1] = true;
                q.add(new int[]{x - 1, time + 1});
            }
        }

    }
}