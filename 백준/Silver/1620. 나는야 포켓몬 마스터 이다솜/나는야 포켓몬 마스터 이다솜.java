import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static HashMap<String, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N + 1; i++) {
            String name = br.readLine();
            map.put(name, Integer.toString(i));
            map.put(Integer.toString(i), name);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            sb.append(map.get(input));
            sb.append("\n");
        }

        System.out.print(sb);
    }
}