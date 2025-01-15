import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] selected;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];
        isSelected = new boolean[N + 1];

        combination(1, 0);

        System.out.println(sb);
    }

    public static void combination(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i < N + 1; i++) {
            isSelected[i] = true;
            selected[cnt] = i;
            combination(i + 1, cnt + 1);
            isSelected[i] = false;
        }
    }
}