import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_E = 15;
    static final int MAX_S = 28;
    static final int MAX_M = 19;
    static int E;
    static int S;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());   //1~15
        S = Integer.parseInt(st.nextToken());   //1~28
        M = Integer.parseInt(st.nextToken());   //1~19

        int year = 1;
        while (true) {
            if (((year - E) % MAX_E == 0) && ((year - S) % MAX_S == 0) && ((year - M) % MAX_M) == 0) break;
            year += 1;
        }

        System.out.println(year);


    }
}