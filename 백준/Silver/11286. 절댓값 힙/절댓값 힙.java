import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> q = new PriorityQueue<>(
                Comparator.comparing((int[] ints) -> ints[0])
                        .thenComparing(ints -> ints[1])
        );

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {

                if (q.isEmpty()) {
                    sb.append(0);
                } else {
                    int[] now = q.poll();
                    sb.append(now[0] * now[1]);
                }
                sb.append("\n");
                continue;
            }

            if (n < 0) {
                q.add(new int[]{Math.abs(n),-1});
            } else {
                q.add(new int[]{n,1});
            }
        }

        System.out.print(sb);
    }
}