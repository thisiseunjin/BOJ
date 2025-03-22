import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] time = new int[200_001];
    static int N, K;
    static int result = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(time, (int) 1e9);

        bfs();
        System.out.println(result);
    }

    public static void bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(ints -> ints[1]));
        time[N] = 0;
        q.add(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == K) {
                result = Math.min(cur[1], result);
                break;
            }

            if (cur[0] * 2 < 200_001 && time[cur[0] * 2] > cur[1] + 1) {
                time[cur[0] * 2] = cur[1] + 1;
                q.add(new int[]{cur[0] * 2, cur[1] + 1});
            }
            //x-1로 이동하는 경우
            if (cur[0] - 1 >= 0 && time[cur[0] - 1] > cur[1] + 1) {
                time[cur[0] - 1] = cur[1] + 1;
                q.add(new int[]{cur[0] - 1, cur[1] + 1});
            }

            if (cur[0] + 1 < 200_001 && time[cur[0] + 1] > cur[1] + 1) {
                time[cur[0] + 1] = cur[1] + 1;
                q.add(new int[]{cur[0] + 1, cur[1] + 1});
            }


        }
    }
}