import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            System.out.println(getCount(map));
        }
    }

    public static int getCount(Map<String, Integer> map) {
        int count = 1;
        for (String key : map.keySet()) {
            count *= (map.get(key) + 1);
        }

        return count - 1;
    }
}