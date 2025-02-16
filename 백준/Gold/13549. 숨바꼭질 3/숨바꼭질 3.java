import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isVisited = new boolean[100_001];

        int result = bfs();
        System.out.println(result);

    }

    public static int bfs() {
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(ints -> ints[1]));
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N, 0});
        isVisited[N] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int x = cur[0];
            int time = cur[1];

//            System.out.println(Arrays.toString(cur));

            if (x == K) return time;

            if (x * 2 < 100_001 && !isVisited[x * 2]) {
                isVisited[x * 2] = true;
                q.add(new int[]{x * 2, time});

            }

            //x-1로 간다
            if (x - 1 >= 0 && !isVisited[x - 1]) {
                isVisited[x - 1] = true;
                q.add(new int[]{x - 1, time + 1});
            }

            if (x + 1 < 100_001 && !isVisited[x + 1]) {
                isVisited[x + 1] = true;
                q.add(new int[]{x + 1, time + 1});
            }


        }
        return -1;
    }
}