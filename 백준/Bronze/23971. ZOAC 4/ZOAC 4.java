import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H;
    static int W;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int n = 0;
        int idx = 0;
        while (idx < H) {
            if (idx % (N + 1) == 0) n++;
            idx++;
        }

        int m = 0;
        idx = 0;
        while (idx < W) {
            if (idx % (M + 1) == 0) m++;
            idx++;
        }

        System.out.println(n * m);
    }
}