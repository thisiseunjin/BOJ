import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String input;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.equals(" ") || str.isBlank() || str.isEmpty()) continue;
            cnt++;
        }

        System.out.println(cnt);
    }
}