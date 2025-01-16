import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] selected;  //지금까지 내가 선택한 수
    static boolean[] isSelected;    //방문 체크를 할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];
        isSelected = new boolean[N + 1];

        combinationA(0);

        System.out.println(sb);
    }

    public static void combinationA(int cnt) {
        if (cnt == M) {
            //다 선택 완료 했음.
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i < N + 1; i++) {
            selected[cnt] = i;
            combinationA(cnt + 1);
        }
    }
}