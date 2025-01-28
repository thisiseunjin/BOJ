import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static StringBuilder sb;
    static Queue<Integer> q;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        q = new ArrayDeque<>();

        sb.append("<");
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N + 1; i++) {
            q.add(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int n = q.poll();
            if (cnt % K != 0) {
                q.add(n);
                continue;
            }

            //맞다면?
            sb.append(n);
            if (q.isEmpty()) {
                sb.append(">");
            } else {
                sb.append(", ");
            }

        }

        System.out.println(sb);
    }

}