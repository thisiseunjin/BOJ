import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 0) {
                q.add(n);
                continue;
            }

            if(q.isEmpty()){
                sb.append(0);
            }else{
                sb.append(q.poll());
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}