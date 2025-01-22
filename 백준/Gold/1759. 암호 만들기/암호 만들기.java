import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;
    static char[] chars;
    static StringBuilder sb;
    static char[] selected;

    static void comb(int start, int cnt, int m, int j) {
        if (cnt == L) {
            if (m < 1) return;
            if (j < 2) return;

            for (int i = 0; i < L; i++) {
                sb.append(selected[i]);
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i < C; i++) {
            selected[cnt] = chars[i];
            if (chars[i] == 'a' || chars[i] == 'e'
                    || chars[i] == 'i' || chars[i] == 'o'
                    || chars[i] == 'u') {
                comb(i + 1, cnt + 1, m + 1, j);
            } else {
                comb(i + 1, cnt + 1, m, j + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        selected = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);
        comb(0, 0, 0, 0);

        System.out.println(sb);
    }

}