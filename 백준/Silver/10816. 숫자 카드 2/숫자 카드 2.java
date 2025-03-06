import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;   //상근이가 가진 숫자 카드의 개수
    static int M;
    static Map<Integer, Integer> have = new HashMap<>();
    static Map<Integer, Integer> search = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            have.put(n, have.getOrDefault(n, 0) + 1);
        }


        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(have.getOrDefault(n, 0)).append(" ");
        }

        System.out.println(sb);
    }
}