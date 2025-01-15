import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;  //지금까지 선택한 수
    static boolean[] isSelected;    //각 숫자가 선택 되었는가?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isSelected = new boolean[N + 1];
        selected = new int[M];

        permutation(0);

        System.out.println(sb);
    }

    public static void permutation(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (isSelected[i]) continue;
            selected[cnt] = i;
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }
}