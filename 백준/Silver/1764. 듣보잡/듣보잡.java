import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static Set<String> noListen = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<String> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            noListen.add(name);
        }
        int result = 0;
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (!noListen.contains(name)) continue;
            q.add(name);
            result++;
        }
       
        sb.append(result).append("\n");
        while (!q.isEmpty()){
            sb.append(q.poll()).append("\n");
        }

        System.out.print(sb);
    }
}