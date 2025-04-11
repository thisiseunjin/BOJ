import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int R;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                for (int j = 0; j < R; j++) {
                    sb.append(ch);
                }
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}