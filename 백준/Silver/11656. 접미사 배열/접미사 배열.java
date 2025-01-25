import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static StringBuilder sb;
    static PriorityQueue<String> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        pq = new PriorityQueue<>();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            String str = input.substring(i);
            pq.add(str);
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll());
            sb.append("\n");
        }

        System.out.println(sb);

    }
}