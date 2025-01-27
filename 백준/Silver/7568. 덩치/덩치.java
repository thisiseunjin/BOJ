import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        info = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            info[i][0] = w;
            info[i][1] = h;
        }

        for (int i = 0; i < N; i++) {
            sb.append(ranking(i));
            sb.append(" ");
        }

        System.out.println(sb);


    }

    static int ranking(int idx) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (idx == i) continue;

            if (info[i][0] > info[idx][0] && info[i][1] > info[idx][1]) cnt++;

        }

        return cnt + 1;
    }
}