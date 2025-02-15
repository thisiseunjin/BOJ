import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;   // 다리를 건너는 트럭의 수
    static int w;   // 다리의 길이
    static int L;   // 다리의 최대하중
    static int[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        weights = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < w; i++) {
            q.add(0);
        }
        int idx = 0;
        int sum = 0;
        int time = 0;
        while (!q.isEmpty()) {
            time++;
            int pre = q.poll();
            sum -= pre;

            if (idx == n) continue;

            //만약에 다음 트럭이 다리를 건널 수 있다면?
            if (sum + weights[idx] <= L) {
                q.add(weights[idx]);
                sum += weights[idx];
                idx++;
            } else {
                q.add(0);
            }

        }

        System.out.println(time);
    }
}